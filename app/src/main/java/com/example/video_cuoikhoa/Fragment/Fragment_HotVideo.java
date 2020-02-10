package com.example.video_cuoikhoa.Fragment;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.video_cuoikhoa.Activity.MainActivity;
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

public class Fragment_HotVideo extends ListFragment {
    View view;
    ListView listView;
   // String[] array ={"hai phong ","hai phong ","hai phong ","hai phong ",};
   ArrayAdapter adapter;
    ArrayList<ItemHotVideo> video;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       view = inflater.inflate(R.layout.hot_video_flagment, container,false);
        //adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,mang);
        //setListAdapter(adapter);
        listView = view.findViewById(R.id.listView);
        video= new ArrayList<ItemHotVideo>();
       // String uri = "http://demo4855049.mockable.io/gethotvideo?fbclid=IwAR0zna1Ya7KWa4neNo6XmD9BUfTLgUDHXIOxrD6HQhqBM8JOwfrn3qT1qo0";
            //new docJSON(uri).execute();
        //   listView.setAdapter(new ListAdapter(getContext(),R.layout.item_hot_video,video));
        return view;
    }
  class docJSON extends AsyncTask<String,String,String>{
      @Override
       protected String doInBackground(String... params) {
           return docNoiDung_Tu_URL(params[0]);
       }

       @Override
       protected void onPostExecute(String s) {
           try {
               JSONArray root = new JSONArray(s);
               for (int i=0;i<root.length();i++){
                   JSONObject hotvideo= root.getJSONObject(i);
                   video.add(new ItemHotVideo(hotvideo.getString("avatar"),
                           hotvideo.getString("title"),
                           hotvideo.getString("file_mp4")));
               }
               listView.setAdapter(new ListAdapter(getContext(),R.layout.item_hot_video,video));
               listView.setAdapter(adapter);
           } catch (JSONException e) {
               e.printStackTrace();
           }
       }
   }
    @org.jetbrains.annotations.NotNull
    private String docNoiDung_Tu_URL(String theUrl){
        StringBuilder content = new StringBuilder();
        try    {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null){
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)    {
            e.printStackTrace();
        }
        return content.toString();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
