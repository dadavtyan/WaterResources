package com.davtyan.waterresources.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davtyan.waterresources.R;
import com.davtyan.waterresources.activitys.MainActivity;
import com.davtyan.waterresources.models.WaterRes;

import java.util.List;

public class WaterAdapter extends RecyclerView.Adapter<WaterHolder>{
    private MainActivity context;
    private List<WaterRes> waterResList;

    public WaterAdapter(MainActivity context, List<WaterRes> waterResList) {
        this.context = context;
        this.waterResList = waterResList;
    }
    @Override
    public WaterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.water_list, parent, false);
        WaterHolder waterHolder = new WaterHolder(view);

        return waterHolder;
    }

    @Override
    public void onBindViewHolder(WaterHolder holder, final int position) {
       holder.initData(waterResList.get(position),context);
       holder.getImageView().setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               context.swipeToWaterResItem(position);
           }
       });
    }

    @Override
    public int getItemCount() {
        return waterResList.size();
    }

//    private void getItem(WaterResAdapter waterRes,int position) {
//        Intent intent= new Intent(context, WeatherActivity.class);
//        intent.putExtra("waterRes",new Gson().toJson(waterRes));
//        intent.putExtra("position",position);
//        context.startActivity(intent);
//    }
}
