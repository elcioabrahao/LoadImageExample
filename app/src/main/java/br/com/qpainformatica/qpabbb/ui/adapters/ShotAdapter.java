package br.com.qpainformatica.qpabbb.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.paging.listview.PagingBaseAdapter;
import com.squareup.picasso.Picasso;

import br.com.qpainformatica.qpabbb.R;
import br.com.qpainformatica.qpabbb.domain.model.Shot;

/**
 * Created by eabrahao on 17/09/15.
 */
public class ShotAdapter extends PagingBaseAdapter<Shot> {

    Context context;
    Picasso mPicasso;
    LayoutInflater mLayoutInflater;

    public ShotAdapter(Context context) {
        this.context=context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mPicasso = Picasso.with(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }


    @Override
    public Shot getItem(int position) { // << subclasses can use subtypes in overridden methods!
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        ImageView ivShot;
        TextView tvShotTitle;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;


        mLayoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.shot_item, null);
            holder = new ViewHolder();

            holder.tvShotTitle = (TextView) convertView.findViewById(R.id.tvShotTitle);
            holder.ivShot = (ImageView) convertView.findViewById(R.id.ivShot);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Shot row_pos = getItem(position);

        mPicasso.with(context)
                .load(row_pos.getImage_400_url())
                .into(holder.ivShot);

        holder.tvShotTitle.setText(row_pos.getTitle());
        return convertView;
    }

}