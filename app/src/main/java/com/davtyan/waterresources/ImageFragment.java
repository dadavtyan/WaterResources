package com.davtyan.waterresources;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Random;

public class ImageFragment extends Fragment {

   private static final String ARGUMENT_1 = "arg_url_image";
   private static final String ARGUMENT_2 = "arg_description";
   private String urlImage;
   private String descriptionStr;
   private int backColor;

    public static ImageFragment newInstance(String url, String description) {
        ImageFragment pageFragment = new ImageFragment();
        Bundle arguments = new Bundle();
        arguments.putString(ARGUMENT_1, url);
        arguments.putString(ARGUMENT_2,description);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        urlImage = getArguments().getString(ARGUMENT_1);
        descriptionStr = getArguments().getString(ARGUMENT_2);

        Random rnd = new Random();
        backColor = Color.argb(40, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_fragment, null);

        TextView description = view.findViewById(R.id.description);
        ImageView imageView = view.findViewById(R.id.image_list);
        Picasso.with(getContext()).load(urlImage).into(imageView);

        description.setText(descriptionStr);
        description.setBackgroundColor(backColor);

        return view;
    }


}