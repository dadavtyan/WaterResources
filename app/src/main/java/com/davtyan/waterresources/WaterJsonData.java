package com.davtyan.waterresources;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by COMP on 16.03.2018.
 */

public class WaterJsonData {

    public static String getData(){
        Map<String,Object> object = new HashMap<>();
        Map<String,List<Object>> list = new HashMap<>();
        List<Object> oceanList = new ArrayList<>();
        Map<String,Object> oceanData = new HashMap<>();
        List<Object> imageList = new ArrayList<>();

        oceanData.put("name", "Тихий");
        imageList.add("https://www.greenpolicy360.net/mw/images/Clouds_over_the_Atlantic_Ocean_wiki_cc.jpg");
        imageList.add("https://upload.wikimedia.org/wikipedia/commons/e/e0/Clouds_over_the_Atlantic_Ocean.jpg");
        imageList.add("http://pics.ourtimedv.com/news/upload/iblock/29c/29c0e325cd30cb76243cd36ad44fad46.jpg");
        oceanData.put("image_list",imageList);
        oceanData.put("description","Тихий Океан");
        oceanList.add(oceanData);
        list.put("ocean",oceanList);

        oceanList = new ArrayList<>();
        oceanData = new HashMap<>();
        imageList = new ArrayList<>();
        oceanData.put("name", "Атлантический");
        imageList.add("http://daxushequ.com/data/out/13/img60604908.jpg");
        imageList.add("http://fotorelax.ru/wp-content/uploads/2015/10/Pristine-Kamchatka-Pacific-ocean-02.jpg");
        imageList.add("https://photofeast.ru/uploads/image/f/6/f6e005f50d4c7383a3026b6a83782cbb.jpg");
        oceanData.put("image_list",imageList);
        oceanData.put("description","Атлантический Океан");
        oceanList.add(oceanData);
        list.put("ocean",oceanList);

        oceanList = new ArrayList<>();
        oceanData = new HashMap<>();
        imageList = new ArrayList<>();
        oceanData.put("name", "Индийский");
        imageList.add("https://wikiway.com/upload/hl-photo/c97/ba6/indian_ocean%20_32.jpg");
        imageList.add("https://a.d-cd.net/d5e0bdu-960.jpg");
        oceanData.put("image_list",imageList);
        oceanData.put("description","Индийский Океан");
        oceanList.add(oceanData);
        list.put("ocean",oceanList);

        oceanData.put("name", "Южный (Антарктический)");
        imageList.add("https://s1.1zoom.ru/big7/420/Mountains_Sea_456567.jpg");
        imageList.add("http://oboi.cc/uploads/new/big/oboik.ru_26005.jpg");
        oceanData.put("image_list",imageList);
        oceanData.put("description","Южный (Антарктический) Океан");
        oceanList.add(oceanData);
        list.put("ocean",oceanList);

        object.put("list", list);
        JSONObject jsonBody = new JSONObject(object);
        return jsonBody.toString();
    }

}
