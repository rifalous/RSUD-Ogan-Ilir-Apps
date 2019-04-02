package com.formaltech.rsudoganilir;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Rifal on 14/03/2019.
 */
public class RoomActivity extends AppCompatActivity {

    private static final String JSON_URL = "https://rifalous.github.io/Pandora-Box/room.json";

    ListView listView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    RoomAdapter adapter;
    private List<RoomItem> roomItemList;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        listView =  findViewById(R.id.listView);
        listView.setDivider(null);
        roomItemList = new ArrayList<>();

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(true);
                Log.d("Swipe", "Refreshing content");

                adapter.clear();
                roomItemList.clear();
                adapter.notifyDataSetChanged();
                loadPlayer();

                Toast.makeText(RoomActivity.this, "Refreshed", Toast.LENGTH_LONG).show();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        loadPlayer();
    }

    private void loadPlayer() { StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            try {
                JSONObject obj = new JSONObject(response);
                JSONArray roomArray = obj.getJSONArray("kamar");

                for (int i = 0; i < roomArray.length(); i++) {
                    JSONObject roomObject = roomArray.getJSONObject(i);
                    RoomItem roomItem = new RoomItem(roomObject.getString("nama"),
                            roomObject.getString("terisi"),
                            roomObject.getString("kosong"));
                    roomItemList.add(roomItem);
                }

                adapter = new RoomAdapter(roomItemList, getApplicationContext());
                listView.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    },

            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
