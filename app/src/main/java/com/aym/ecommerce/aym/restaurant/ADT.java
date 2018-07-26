package com.aym.ecommerce.aym.restaurant;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aym.ecommerce.aym.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class ADT extends BaseAdapter {
    private Context ctx;
    ArrayList<CollectionClass> mArrayList;
    private LayoutInflater inflater = null;

    // Constructor
    public ADT(Context ctx, ArrayList<CollectionClass> mArrayList) {
        this.ctx = ctx;
        this.mArrayList = mArrayList;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return mArrayList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int pos, View row, ViewGroup viewGroup) {

        final ViewHolder holder = new ViewHolder();

        row = inflater.inflate(R.layout.item_rest, null);

        holder.iv = row.findViewById(R.id.iv);
        holder.mTitle = row.findViewById(R.id.mTitle);
        holder.mDesc  = row.findViewById(R.id.mDesc);

        holder.mTitle.setText(mArrayList.get(pos).getTitle());
        holder.mDesc.setText(mArrayList.get(pos).getDescription());

        Glide.with(ctx).load(mArrayList.get(pos).getImage_url())
                .thumbnail(0.5f)
                .into(holder.iv);

        row.setTag(holder);

        return row;
    }

    static class ViewHolder {
        TextView mTitle, mDesc;
        ImageView iv;

    }
}

