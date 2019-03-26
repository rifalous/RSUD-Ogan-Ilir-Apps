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

public class MedicineActivity  extends AppCompatActivity {

    private static final String JSON_URL = "https://rifalous.github.io/Pandora-Box/medicine.json";

    ListView listView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    MedicineAdapter adapter;
    private List<MedicineItem> medicineItemList;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        listView =  findViewById(R.id.listView);
        listView.setDivider(null);
        medicineItemList = new ArrayList<>();

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(true);
                Log.d("Swipe", "Refreshing content");

                adapter.clear();
                medicineItemList.clear();
                adapter.notifyDataSetChanged();
                loadPlayer();

                Toast.makeText(MedicineActivity.this, "Refreshed", Toast.LENGTH_LONG).show();
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
                    JSONArray medicineArray = obj.getJSONArray("obat");

                    for (int i = 0; i < medicineArray.length(); i++) {
                        JSONObject medicineObject = medicineArray.getJSONObject(i);
                        MedicineItem medicineItem = new MedicineItem(medicineObject.getString("nama"),
                                medicineObject.getString("satuan"),
                                medicineObject.getString("stok"));
                        medicineItemList.add(medicineItem);
                    }

                    adapter = new MedicineAdapter(medicineItemList, getApplicationContext());
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
