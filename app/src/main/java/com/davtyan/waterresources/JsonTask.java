package com.davtyan.waterresources;

import android.os.AsyncTask;

import com.davtyan.waterresources.activitys.MainActivity;
import com.davtyan.waterresources.models.WaterRes;

import java.util.List;


public class JsonTask  extends AsyncTask<Void,Void,List<WaterRes>> {
    private MainActivity activity;


    public JsonTask(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected List<WaterRes> doInBackground(Void... voids) {
        return new LoadJson().fetchItems();
    }

    @Override
    protected void onPostExecute(List<WaterRes> cities) {
        super.onPostExecute(cities);
        activity.setAdapter(cities);

    }
}
