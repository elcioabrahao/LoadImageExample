package br.com.qpainformatica.qpabbb.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.paging.listview.PagingListView;

import java.util.List;

import br.com.qpainformatica.qpabbb.R;
import br.com.qpainformatica.qpabbb.domain.model.Page;
import br.com.qpainformatica.qpabbb.domain.model.Shot;
import br.com.qpainformatica.qpabbb.domain.network.APIClient;
import br.com.qpainformatica.qpabbb.domain.tasks.SafeAsyncTask;
import br.com.qpainformatica.qpabbb.ui.adapters.ShotAdapter;

public class MainActivity extends ActionBarActivity {

    private PagingListView listView;
    private ShotAdapter adapter;

    private int pager = 1;
    private int maxPageSize = 99999;
    public static final String SHOT_DETAIL = "br.com.qpainformatica.qpabbb.shotDetail";
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (PagingListView) findViewById(R.id.paging_list_view);
        adapter = new ShotAdapter(this);
        intent = new Intent(this,ShotDetailActivity.class);


        listView.setAdapter(adapter);
        listView.setHasMoreItems(true);
        listView.setPagingableListener(new PagingListView.Pagingable() {
            @Override
            public void onLoadMoreItems() {
                if (pager < maxPageSize) {
                    new PopularShotsAsyncTask().execute();
                } else {
                    listView.onFinishLoading(false, null);
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Shot shot = adapter.getItem(position);
                intent.putExtra(SHOT_DETAIL,shot.getId());
                startActivity(intent);
            }
        });

    }

    private void clearData() {
        pager = 0;
        adapter.removeAllItems();
        listView.setHasMoreItems(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                clearData();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private class PopularShotsAsyncTask extends SafeAsyncTask<List<Shot>> {


        @Override
        public List<Shot> call() throws Exception {


            Page myPage = new APIClient().getShots().getWith(pager);
            maxPageSize = myPage.getPages();
            List<Shot> result = myPage.getShots();

            Log.d("JSON", "Number of shots: "+myPage.getShots().size());

            return result;
        }

        @Override
        protected void onSuccess(List<Shot> newItems) throws Exception {
            super.onSuccess(newItems);
            pager++;
            listView.onFinishLoading(true, newItems);
        }
    }

}
