package com.example.video_cuoikhoa.Fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.video_cuoikhoa.Activity.PlayVideo;
import com.example.video_cuoikhoa.Adapter.ListAdapter;
import com.example.video_cuoikhoa.Data.ItemHotVideo;
import com.example.video_cuoikhoa.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Fragment_HotVideo extends Fragment {
    View view;
    ListView listView;
    // String[] array ={"hai phong ","hai phong ","hai phong ","hai phong ",};
    ListAdapter adapter;
    ArrayList<ItemHotVideo> videos;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.hot_video_flagment, container, false);
        //adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,mang);
        //setListAdapter(adapter);
        listView = view.findViewById(R.id.listView);
        progressBar = view.findViewById(R.id.prBar);

        // String uri = "http://demo4855049.mockable.io/gethotvideo?fbclid=IwAR0zna1Ya7KWa4neNo6XmD9BUfTLgUDHXIOxrD6HQhqBM8JOwfrn3qT1qo0";
        //new docJSON(uri).execute();
        //   listView.setAdapter(new ListAdapter(getContext(),R.layout.item_hot_video,video));
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        videos = new ArrayList<ItemHotVideo>();
        //progressBar.setVisibility(View.VISIBLE);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new docJSON().execute("http://demo4855049.mockable.io/gethotvideo?fbclid=IwAR0m_3Ax8yYT9wFyeZno5vb2S9VD-oTCDbQAdwWvvaRNTsgPI7-x8y2-zO0");
            }
        });

    }

    class docJSON extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_Tu_URL(params[0]);
        }


        @Override
        protected void onPostExecute(String s) {

            try {
                JSONArray root = new JSONArray(s);
                for (int i = 0; i < root.length(); i++) {
                    JSONObject hotvideo = root.getJSONObject(i);
                    videos.add(new ItemHotVideo(hotvideo.getString("avatar"),
                            hotvideo.getString("title"),
                            hotvideo.getString("file_mp4")));
                }
                ListAdapter adapter = new ListAdapter(getActivity().getApplicationContext(),
                        R.layout.item_hot_video, videos);
                //Toast.makeText(getContext()," "+video.size(),Toast.LENGTH_LONG).show();
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getActivity().getBaseContext(), PlayVideo.class);
                        intent.putExtra("URL", videos.get(position).getVideo());
                        intent.putExtra("Title",videos.get(position).getTitle());
                        startActivity(intent);
                    }
                });

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }


    @org.jetbrains.annotations.NotNull
    private String docNoiDung_Tu_URL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }


}
