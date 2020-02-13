package com.example.video_cuoikhoa.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.video_cuoikhoa.Adapter.CategoryAdapter;
import com.example.video_cuoikhoa.Data.ItemCategory;
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
import java.util.List;

public class Fragment_Category extends Fragment {
    View view;
    ArrayList<ItemCategory> itemCategories;
    ListView listCategory;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.category_fragment, container, false);
        listCategory = view.findViewById(R.id.lvcategory);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemCategories = new ArrayList<>();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new docJsonCategory().execute("http://demo4855049.mockable.io/GetCategory?fbclid=IwAR3gCt-pWgIw_uHjUBuLNgv_I_f9fvKaRGxykXWo-4jZPsZJYROPzCDeUQo");
            }
        });
    }


    class docJsonCategory extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_Tu_URL(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {

            try {
                JSONArray root = new JSONArray(s);
                for (int i = 0; i < root.length(); i++) {
                    JSONObject categoryvideo = root.getJSONObject(i);
                    itemCategories.add(new ItemCategory(categoryvideo.getString("title")
                            , categoryvideo.getString("thumb")));
                }
                CategoryAdapter adapter = new CategoryAdapter(getActivity().getApplicationContext(),
                        R.layout.item_category, itemCategories);
                listCategory.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

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
}
