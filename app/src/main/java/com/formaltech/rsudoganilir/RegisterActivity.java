package com.formaltech.rsudoganilir;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Objects;

/**
 * Created by Rifal on 14/03/2019.
 */
public class RegisterActivity extends AppCompatActivity {

    LinearLayout linearReserv;
    Toolbar toolbar;
    Button btn_recon;
    ImageView no_internet_iv;
    TextView title_status, subtitle_status, label_pasien, label_reservasi;
    MaterialEditText rekamedikEditText, namapasienEditText, tanggaljam, poliEditText, namadokterEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        linearReserv = findViewById(R.id.linearReserv);
        title_status = findViewById(R.id.title_status);
        subtitle_status = findViewById(R.id.subtitle_status);
        no_internet_iv = findViewById(R.id.no_internet_iv);
        btn_recon = findViewById(R.id.btn_recon);
        label_pasien = findViewById(R.id.label_pasien);
        label_reservasi = findViewById(R.id.label_reservasi);
        rekamedikEditText = findViewById(R.id.rekamedikEditText);
        namapasienEditText = findViewById(R.id.namapasienEditText);
        tanggaljam = findViewById(R.id.tanggaljam);
        poliEditText = findViewById(R.id.poliEditText);
        namadokterEditText = findViewById(R.id.namadokterEditText);

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
                label_pasien.setVisibility(View.VISIBLE);
                label_reservasi.setVisibility(View.VISIBLE);
                rekamedikEditText.setVisibility(View.VISIBLE);
                namapasienEditText.setVisibility(View.VISIBLE);
                tanggaljam.setVisibility(View.VISIBLE);
                poliEditText.setVisibility(View.VISIBLE);
                namadokterEditText.setVisibility(View.VISIBLE);
                linearReserv.setBackgroundResource(R.color.colorWhite);

            }
        } else {
            toolbar.setVisibility(View.GONE);
            no_internet_iv.setVisibility(View.VISIBLE);
            title_status.setVisibility(View.VISIBLE);
            subtitle_status.setVisibility(View.VISIBLE);
            btn_recon.setVisibility(View.VISIBLE);
            label_pasien.setVisibility(View.GONE);
            label_reservasi.setVisibility(View.GONE);
            rekamedikEditText.setVisibility(View.GONE);
            namapasienEditText.setVisibility(View.GONE);
            tanggaljam.setVisibility(View.GONE);
            poliEditText.setVisibility(View.GONE);
            namadokterEditText.setVisibility(View.GONE);
            linearReserv.setBackgroundResource(R.color.colorPrimaryDark);
            Toast.makeText(getApplicationContext(),"Tidak Terhubung ke Internet", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
