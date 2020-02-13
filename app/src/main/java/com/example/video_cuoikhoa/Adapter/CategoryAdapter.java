package com.example.video_cuoikhoa.Adapter;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.video_cuoikhoa.Data.ItemCategory;
import com.example.video_cuoikhoa.Data.ItemHotVideo;
import com.example.video_cuoikhoa.R;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends ArrayAdapter<ItemCategory> {


    public CategoryAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
    private List<ItemCategory> items;

    public CategoryAdapter(Context context, int resource, List<ItemCategory> items) {

        super(context, resource, items);

        this.items = items;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.item_category, null);

        }

        ItemCategory p = items.get(position);

        if (p != null) {

            TextView textView = (TextView) v.findViewById(R.id.tvcategory);
            textView.setText(p.getTitleCategory());
            ImageView imgcategory= v.findViewById(R.id.imgcategoty);
            Picasso.with(getContext()).load(p.ImgCategory).into(imgcategory);


        }
        return v;
    }
}
