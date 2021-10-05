package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

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

public class WeaponActivity extends AppCompatActivity {

    private String url = "https://my-json-server.typicode.com/marco-lunardeli/trabalhoMobile/weaponds";

    private RecyclerView recyclerView;
    private List<Weapon> weaponList;
    private WeaponAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon);
        recyclerView = findViewById(R.id.weapon_list);

        weaponList = new ArrayList<>();

        extractWeapon();
    }

    private void extractWeapon() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject mangaObject = response.getJSONObject(i);

                        Weapon manga = new Weapon();
                        manga.setName(mangaObject.getString("name"));

                        weaponList.add(manga);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new WeaponAdapter(getApplicationContext(), weaponList);
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