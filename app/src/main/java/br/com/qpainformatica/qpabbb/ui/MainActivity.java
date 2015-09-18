package br.com.qpainformatica.qpabbb.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.paging.listview.PagingListView;

import java.util.List;

import br.com.qpainformatica.qpabbb.R;
import br.com.qpainformatica.qpabbb.domain.model.Page;
import br.com.qpainformatica.qpabbb.domain.model.Shot;
import br.com.qpainformatica.qpabbb.domain.network.APIClient;
import br.com.qpainformatica.qpabbb.domain.tasks.SafeAsyncTask;
import br.com.qpainformatica.qpabbb.ui.adapters.ShotAdapter;

public class MainActivity extends Activity {

    private PagingListView listView;
    private ShotAdapter adapter;

    private List<String> firstList;
    private List<String> secondList;
    private List<String> thirdList;

    private int pager = 1;
    private int maxPageSize = 99999;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (PagingListView) findViewById(R.id.paging_list_view);
        adapter = new ShotAdapter(this);


        listView.setAdapter(adapter);
        listView.setHasMoreItems(true);
        listView.setPagingableListener(new PagingListView.Pagingable() {
            @Override
            public void onLoadMoreItems() {
                if (pager < maxPageSize) {
                    new CountryAsyncTask().execute();
                } else {
                    listView.onFinishLoading(false, null);
                }
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



    private class CountryAsyncTask extends SafeAsyncTask<List<Shot>> {


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
