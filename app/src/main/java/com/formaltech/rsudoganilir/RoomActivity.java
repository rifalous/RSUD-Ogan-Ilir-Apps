package com.formaltech.rsudoganilir;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
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
    LinearLayout linearReserv;
    RoomAdapter adapter;
    private List<RoomItem> roomItemList;
    Toolbar toolbar;
    Button btn_recon;
    ImageView no_internet_iv;
    TextView title_status, subtitle_status;

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
        listView = findViewById(R.id.listView);
        listView.setDivider(null);
        roomItemList = new ArrayList<>();

        title_status = findViewById(R.id.title_status);
        subtitle_status = findViewById(R.id.subtitle_status);
        no_internet_iv = findViewById(R.id.no_internet_iv);
        btn_recon = findViewById(R.id.btn_recon);
        linearReserv = findViewById(R.id.linearReserv);

        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");

        title_status.setTypeface(Vidaloka);
        subtitle_status.setTypeface(MLight);
        btn_recon.setTypeface(MMedium);

        btn_recon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkNetworkConnectStatus();
            }
        });

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
            }
        });

        loadPlayer();
        checkNetworkConnectStatus();
    }

    private void loadPlayer() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL, new Response.Listener<String>() {
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
                    mSwipeRefreshLayout.setRefreshing(false);

                } catch (JSONException e) {
                    mSwipeRefreshLayout.setRefreshing(false);
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

    private void checkNetworkConnectStatus() {
        boolean wifiConnected;
        boolean mobileConnected;

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();

        if (activeInfo != null && activeInfo.isConnected()) {
            wifiConnected = activeInfo.getType() == ConnectivityManager.TYPE_WIFI;
            mobileConnected = activeInfo.getType() == ConnectivityManager.TYPE_MOBILE;

            if (wifiConnected || mobileConnected) {
                toolbar.setVisibility(View.VISIBLE);
                no_internet_iv.setVisibility(View.GONE);
                title_status.setVisibility(View.GONE);
                subtitle_status.setVisibility(View.GONE);
                btn_recon.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                linearReserv.setBackgroundResource(R.color.colorWhite);
            }
        } else {
            toolbar.setVisibility(View.GONE);
            no_internet_iv.setVisibility(View.VISIBLE);
            title_status.setVisibility(View.VISIBLE);
            subtitle_status.setVisibility(View.VISIBLE);
            btn_recon.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
            linearReserv.setBackgroundResource(R.color.colorPrimaryDark);
            Toast.makeText(getApplicationContext(), "Tidak Terhubung ke Internet", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
