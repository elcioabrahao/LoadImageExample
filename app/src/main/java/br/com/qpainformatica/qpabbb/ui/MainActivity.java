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
import br.com.qpainformatica.qpabbb.R;
import br.com.qpainformatica.qpabbb.domain.model.Page;
import br.com.qpainformatica.qpabbb.domain.model.Shot;
import br.com.qpainformatica.qpabbb.domain.network.APIClient;
import br.com.qpainformatica.qpabbb.ui.adapters.ShotAdapter;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends ActionBarActivity {

    private PagingListView listView;
    private ShotAdapter adapter;

    private int pager = 1;
    private int maxPageSize = 99999;
    public static final String SHOT_DETAIL = "br.com.qpainformatica.qpabbb.shotDetail";
    Intent intent;
    private Callback<Page> callback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureImageCallback();

        listView = (PagingListView) findViewById(R.id.paging_list_view);
        adapter = new ShotAdapter(this);
        intent = new Intent(this,ShotDetailActivity.class);


        listView.setAdapter(adapter);
        listView.setHasMoreItems(true);
        listView.setPagingableListener(new PagingListView.Pagingable() {
            @Override
            public void onLoadMoreItems() {
                if (pager < maxPageSize) {
                    new APIClient().getShots().getPopularShotsWith(pager, callback);
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


    private void configureImageCallback() {

        callback = new Callback<Page>() {

            @Override public void success(Page myPage, Response response) {
                maxPageSize = myPage.getPages();
                pager++;
                listView.onFinishLoading(true, myPage.getShots());
            }

            @Override public void failure(RetrofitError error) {

                    Log.e("RETROFIT", "Error:"+error.getMessage());
            }
        };
    }

}
