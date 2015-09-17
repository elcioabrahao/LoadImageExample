package br.com.qpainformatica.qpabbb.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.qpainformatica.qpabbb.R;
import br.com.qpainformatica.qpabbb.domain.model.Shot;

/**
 * Created by eabrahao on 17/09/15.
 */
public class ShotAdapter extends BaseAdapter {

    Context context;
    List<Shot> shotItems;

    ShotAdapter(Context context, List<Shot> shotItems) {
        this.context = context;
        this.shotItems = shotItems;
    }

    @Override
    public int getCount() {
        return shotItems.size();
    }

    @Override
    public Object getItem(int position) {
        return shotItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return shotItems.indexOf(getItem(position));
    }

    private class ViewHolder {
        ImageView ivShot;
        TextView tvShotTitle;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.shot_item, null);
            holder = new ViewHolder();

            holder.tvShotTitle = (TextView) convertView.findViewById(R.id.tvShotTitle);
            holder.ivShot = (ImageView) convertView.findViewById(R.id.ivShot);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Shot row_pos = shotItems.get(position);

        // TODO tirar isso
//        Picasso.with(context)
//                .load(row_pos.getItem_image_url())
//                .into(holder.ivMenu);
//
//        holder.tvMenuHeader.setText(row_pos.getItem_header());
//
//        Log.e("Test", "headers:" + row_pos.getItem_header());
        return convertView;
    }

}