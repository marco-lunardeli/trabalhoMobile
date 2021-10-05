package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private String url = "https://my-json-server.typicode.com/marco-lunardeli/trabalhoMobile/response";

    private RecyclerView recyclerView;
    private List<Manga> mangaList;
    private MangaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        recyclerView = findViewById(R.id.main_list);

        mangaList = new ArrayList<>();

        extractMangas();


    }

    private void extractMangas() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject mangaObject = response.getJSONObject(i);

                        Manga manga = new Manga();
                        manga.setName(mangaObject.getString("name"));
                        manga.setStatus(mangaObject.getString("status"));
                        manga.setCreatedAt(mangaObject.getString("createdAt"));

                        mangaList.add(manga);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new MangaAdapter(getApplicationContext(), mangaList);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse : " + error.getMessage());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

}