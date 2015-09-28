package br.com.qpainformatica.qpabbb.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import br.com.qpainformatica.qpabbb.R;
import br.com.qpainformatica.qpabbb.domain.model.Shot;
import br.com.qpainformatica.qpabbb.domain.network.APIClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ShotDetailActivity extends AppCompatActivity {

    private long shotId;
    private TextView desc;
    private TextView name;
    private ImageView image;
    private ImageView avatar;
    private Picasso mPicasso;
    private ProgressBar progressBar;
    private Callback<Shot> callback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shot_detail);

        desc = (TextView)findViewById(R.id.tvDesc);
        name = (TextView)findViewById(R.id.tvPlayerName);
        image = (ImageView)findViewById(R.id.ivShotDetail);
        avatar = (ImageView)findViewById(R.id.ivPlayer);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setIndeterminate(true);

        Intent intent = getIntent();
        shotId = intent.getLongExtra(MainActivity.SHOT_DETAIL,0);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        configureImageCallback();
        new APIClient().getShots().getShotDetailWith(shotId, callback);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    private void configureImageCallback() {

        callback = new Callback<Shot>() {

            @Override public void success(Shot shot, Response response) {

                if(shot.getDescription()!=null) {
                    desc.setText(Html.fromHtml(shot.getDescription()));
                }else{
                    desc.setText(getResources().getString(R.string.noDescription));
                }
                if(shot.getPlayer().getName()!=null) {
                    name.setText(shot.getPlayer().getName());
                }else{
                    name.setText(getResources().getString(R.string.noPlayerName));
                }


                if(shot.getImage400Url() !=null && !shot.getImage400Url().equals("")) {
                    mPicasso.with(ShotDetailActivity.this)
                            .load(shot.getImage400Url())
                            .into(image);
                }else{
                    if(shot.getImageUrl() != null && !shot.getImageUrl().equals("")) {
                        mPicasso.with(ShotDetailActivity.this)
                                .load(shot.getImageUrl())
                                .into(image);
                    }else {
                        mPicasso.with(ShotDetailActivity.this)
                                .load(R.drawable.sem_imagem)
                                .into(image);
                    }
                }

                if (shot.getPlayer().getAvatarUrl() !=null && !shot.getPlayer().getAvatarUrl().equals("")) {
                    mPicasso.with(ShotDetailActivity.this)
                            .load(shot.getPlayer().getAvatarUrl())
                            .into(avatar);

                }else{
                    mPicasso.with(ShotDetailActivity.this)
                            .load(R.drawable.noavatar)
                            .fit()
                            .into(avatar);
                }

                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override public void failure(RetrofitError error) {

                Log.e("RETROFIT", "Error:" + error.getMessage());
            }
        };
    }

}
