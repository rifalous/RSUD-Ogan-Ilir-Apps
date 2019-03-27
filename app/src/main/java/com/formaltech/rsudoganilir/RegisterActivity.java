package com.formaltech.rsudoganilir;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

/**
 * Created by Rifal on 14/03/2019.
 */
public class RegisterActivity extends AppCompatActivity {

    ConstraintLayout constraintReserv;
    Toolbar toolbar;
    Button btn_recon;
    ImageView no_internet_iv;
    TextView title_status, subtitle_status, masih_kosong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        constraintReserv = findViewById(R.id.constraintReserv);
        title_status = findViewById(R.id.title_status);
        subtitle_status = findViewById(R.id.subtitle_status);
        masih_kosong = findViewById(R.id.masih_kosong);
        no_internet_iv = findViewById(R.id.no_internet_iv);
        btn_recon = findViewById(R.id.btn_recon);

        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");

        title_status.setTypeface(Vidaloka);
        subtitle_status.setTypeface(MLight);
        btn_recon.setTypeface(MMedium);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btn_recon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkNetworkConnectStatus();
            }
        });

        checkNetworkConnectStatus();

    }

    @SuppressLint("ResourceAsColor")
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
                masih_kosong.setVisibility(View.VISIBLE);
                constraintReserv.setBackgroundResource(R.color.colorSecondary);

            }
        } else {
            toolbar.setVisibility(View.GONE);
            no_internet_iv.setVisibility(View.VISIBLE);
            title_status.setVisibility(View.VISIBLE);
            subtitle_status.setVisibility(View.VISIBLE);
            btn_recon.setVisibility(View.VISIBLE);
            masih_kosong.setVisibility(View.GONE);
            constraintReserv.setBackgroundResource(R.color.colorPrimaryDark);
            Toast.makeText(getApplicationContext(),"Tidak Terhubung ke Internet", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
