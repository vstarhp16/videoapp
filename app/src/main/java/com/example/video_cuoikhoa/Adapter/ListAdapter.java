package com.example.video_cuoikhoa.Adapter;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;


import com.example.video_cuoikhoa.Activity.PlayVideo;
import com.example.video_cuoikhoa.Data.ItemHotVideo;
import com.example.video_cuoikhoa.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends ArrayAdapter<ItemHotVideo> {

    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        // TODO Auto-generated constructor stub
    }

    private List<ItemHotVideo> items;

    public ListAdapter(Context context, int resource, List<ItemHotVideo> items) {

        super(context, resource, items);

        this.items = items;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.item_hot_video, null);

        }

        ItemHotVideo p = items.get(position);

        if (p != null) {

            TextView tt = (TextView) v.findViewById(R.id.tvhotvideo);
            tt.setText(p.getTitle());
            ImageView imgv= v.findViewById(R.id.imagehotvideo);
            Picasso.with(getContext()).load(p.image).into(imgv);
            Uri uri = Uri.parse(p.getVideo());
            VideoView videoView = v.findViewById(R.id.videoview);




        }
        return v;
    }
}