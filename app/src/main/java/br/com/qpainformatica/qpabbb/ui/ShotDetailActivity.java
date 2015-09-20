package br.com.qpainformatica.qpabbb.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.qpainformatica.qpabbb.R;
import br.com.qpainformatica.qpabbb.domain.model.Shot;
import br.com.qpainformatica.qpabbb.domain.network.APIClient;
import br.com.qpainformatica.qpabbb.domain.tasks.SafeAsyncTask;

public class ShotDetailActivity extends AppCompatActivity {

    private long shotId;
    private TextView desc;
    private TextView name;
    private ImageView image;
    private ImageView avatar;
    private Picasso mPicasso;
    private ProgressBar progressBar;


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

        new ShotDetailAsyncTask().execute();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    private class ShotDetailAsyncTask extends SafeAsyncTask<Shot> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        };

        @Override
        public Shot call() throws Exception {


            Shot mShot = new APIClient().getShotDetail().getWith(shotId);

            return mShot;
        }

        @Override
        protected void onSuccess(Shot shot) throws Exception {
            super.onSuccess(shot);

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


            if(shot.getImage_400_url()!=null && !shot.getImage_400_url().equals("")) {
                mPicasso.with(ShotDetailActivity.this)
                        .load(shot.getImage_400_url())
                        .into(image);
            }else{
                if(shot.getImage_url() != null && !shot.getImage_url().equals("")) {
                    mPicasso.with(ShotDetailActivity.this)
                            .load(shot.getImage_url())
                            .into(image);
                }else {
                    mPicasso.with(ShotDetailActivity.this)
                            .load(R.drawable.sem_imagem)
                            .into(image);
                }
            }

                if (shot.getPlayer().getAvatar_url()!=null && !shot.getPlayer().getAvatar_url().equals("")) {
                mPicasso.with(ShotDetailActivity.this)
                        .load(shot.getPlayer().getAvatar_url())
                        .into(avatar);

            }else{
                mPicasso.with(ShotDetailActivity.this)
                        .load(R.drawable.noavatar)
                        .fit()
                        .into(avatar);
            }

            progressBar.setVisibility(View.INVISIBLE);
        }

    }

}
