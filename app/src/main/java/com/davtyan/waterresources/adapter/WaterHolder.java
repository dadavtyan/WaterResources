package com.davtyan.waterresources.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.davtyan.waterresources.R;
import com.davtyan.waterresources.models.WaterRes;
import com.squareup.picasso.Picasso;

public class WaterHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView textView;

    public WaterHolder(View view) {
        super(view);
        imageView = view.findViewById(R.id.water_item_image);
        textView = view.findViewById(R.id.water_res);
    }
    public void initData(WaterRes waterRes, Context context){
        //imageView.setImageURI(Uri.parse());
        Picasso.with(context).load(waterRes.getWaterArray().get(0).getImageList().get(0)).into(imageView);
        textView.setText(waterRes.getNameRes());
    }

    public ImageView getImageView() {
        return imageView;
    }
}
