package com.davtyan.waterresources.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.davtyan.waterresources.R;
import com.davtyan.waterresources.models.WaterModel;
import com.squareup.picasso.Picasso;


class WaterResHolder  extends RecyclerView.ViewHolder{
    private ImageView imageView;
    private TextView name;
    private TextView description;

    public WaterResHolder(View view) {
        super(view);
        imageView = view.findViewById(R.id.water_item_image);
        name = view.findViewById(R.id.name);
        description = view.findViewById(R.id.description);
    }
    public void initData(WaterModel model, Context context){
        Picasso.with(context).load(model.getImageList().get(0)).into(imageView);
        name.setText(model.getName());
       // description.setText(model.getDescription());
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getDescription() {
        return description;
    }
}
