package com.davtyan.waterresources.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.davtyan.waterresources.ImageFragment;
import com.davtyan.waterresources.R;
import com.davtyan.waterresources.models.WaterModel;
import com.google.gson.Gson;

public class WaterDetailsActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    private String json;
    private WaterModel model;

    private String imageUrl;
    private String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_details);


        if (getIntent().getStringExtra("water") != null) {
            json = (String) getIntent().getSerializableExtra("water");
            model = new Gson().fromJson(json, WaterModel.class);
            initView();
        }

    }

    private void initView() {
        viewPager = findViewById(R.id.viewPager);
        description = model.getDescription();
        pagerAdapter = new MyFragmentPagerAdapter(this.getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(WaterDetailsActivity.this, MainActivity.class));
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            imageUrl = model.getImageList().get(position);
            return ImageFragment.newInstance(imageUrl, description);
        }

        @Override
        public int getCount() {
            return model.getImageList().size();
        }

    }
}
