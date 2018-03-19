package com.davtyan.waterresources.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davtyan.waterresources.R;
import com.davtyan.waterresources.activitys.MainActivity;
import com.davtyan.waterresources.activitys.WaterDetailsActivity;
import com.davtyan.waterresources.models.WaterModel;
import com.google.gson.Gson;

import java.util.List;

public class WaterResAdapter extends RecyclerView.Adapter<WaterResHolder> {
    private MainActivity context;
    private List<WaterModel> waterModels;

    public WaterResAdapter(MainActivity context, List<WaterModel> waterModels) {
        this.context = context;
        this.waterModels = waterModels;
    }

    @Override
    public WaterResHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.water_res_list, parent, false);
        WaterResHolder waterHolder = new WaterResHolder(view);

        return waterHolder;
    }

    @Override
    public void onBindViewHolder(WaterResHolder holder,final int position) {
        holder.initData(waterModels.get(position),context);
        final WaterModel waterModel = waterModels.get(position);
        holder.getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getItem(waterModel,position);
            }
        });
    }

    private void getItem(WaterModel model,int position) {
        Intent intent= new Intent(context, WaterDetailsActivity.class);
        intent.putExtra("water",new Gson().toJson(model));
        context.startActivity(intent);
    }


    @Override
    public int getItemCount() {
        return waterModels.size();
    }
}
