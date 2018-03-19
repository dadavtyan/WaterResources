package com.davtyan.waterresources;

import com.davtyan.waterresources.models.WaterRes;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class LoadJson {

    private String getJsonData(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    public List<WaterRes> fetchItems() {
        List<WaterRes> waterRes = new ArrayList<>();

        String url = "http://www.mocky.io/v2/5aad62b62f0000100020497d";
        String json = null;
        try {
            json = getJsonData(url);
            JSONObject jsonObject = new JSONObject(json);
            parseItem(waterRes, jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return waterRes;
    }
    private void parseItem(List<WaterRes> waterRes, JSONObject jsonObject)
            throws IOException, JSONException {
        JSONArray jsonArray = jsonObject.getJSONArray("waterresources");
        Gson gson = new Gson();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            WaterRes res = gson.fromJson(object.toString(), WaterRes.class);
            waterRes.add(res);
        }
    }
}
