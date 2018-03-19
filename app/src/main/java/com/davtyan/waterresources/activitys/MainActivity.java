package com.davtyan.waterresources.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ViewFlipper;

import com.davtyan.waterresources.JsonTask;
import com.davtyan.waterresources.R;
import com.davtyan.waterresources.adapter.WaterAdapter;
import com.davtyan.waterresources.adapter.WaterResAdapter;
import com.davtyan.waterresources.models.WaterRes;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView recyclerViewItem;
    private ViewFlipper flipper;
    private List<WaterRes> waterRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper = findViewById(R.id.flipper);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewItem = findViewById(R.id.recyclerView_item);
        recyclerViewItem.setLayoutManager(new LinearLayoutManager(this));


        new JsonTask(this).execute();

    }

    public void setAdapter(List<WaterRes> waterRes) {
        this.waterRes = waterRes;
        recyclerView.setAdapter(new WaterAdapter(this, waterRes));
    }

    public void swipeToWaterResItem(int position) {
        recyclerViewItem.setAdapter(new WaterResAdapter(this, waterRes.get(position).getWaterArray()));
        flipper.showNext();
    }

    @Override
    public void onBackPressed() {
        flipper.showPrevious();
    }

}
