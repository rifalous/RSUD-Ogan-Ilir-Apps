package com.formaltech.rsudoganilir;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Calendar;
import java.util.Objects;

/**
 * Created by Rifal on 14/03/2019.
 */
public class RegisterActivity extends AppCompatActivity {

    String amPm;
    Calendar calendar;
    LinearLayout linearReserv;
    Toolbar toolbar;
    Button btn_recon, btn_submit;
    ImageView no_internet_iv;
    TextView title_status, subtitle_status, label_pasien, label_reservasi;
    MaterialEditText rekamedikEditText, namapasienEditText, pilihtanggalEditText, pilihjamEditText, poliEditText, namadokterEditText;
    int currentHour, currentMinute, year, month, dayOfMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        linearReserv = findViewById(R.id.linearReserv);
        title_status = findViewById(R.id.title_status);
        subtitle_status = findViewById(R.id.subtitle_status);
        no_internet_iv = findViewById(R.id.no_internet_iv);
        btn_recon = findViewById(R.id.btn_recon);
        btn_submit = findViewById(R.id.btn_submit);
        label_pasien = findViewById(R.id.label_pasien);
        label_reservasi = findViewById(R.id.label_reservasi);
        rekamedikEditText = findViewById(R.id.rekamedikEditText);
        namapasienEditText = findViewById(R.id.namapasienEditText);
        pilihtanggalEditText = findViewById(R.id.pilih_tanggal);
        pilihjamEditText = findViewById(R.id.pilih_jam);
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

        pilihjamEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(RegisterActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = " PM";
                        } else {
                            amPm = " AM";
                        }
                        pilihjamEditText.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });

        pilihtanggalEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                pilihtanggalEditText.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
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
                btn_submit.setVisibility(View.VISIBLE);
                label_pasien.setVisibility(View.VISIBLE);
                label_reservasi.setVisibility(View.VISIBLE);
                rekamedikEditText.setVisibility(View.VISIBLE);
                namapasienEditText.setVisibility(View.VISIBLE);
                pilihtanggalEditText.setVisibility(View.VISIBLE);
                pilihjamEditText.setVisibility(View.VISIBLE);
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
            btn_submit.setVisibility(View.GONE);
            label_pasien.setVisibility(View.GONE);
            label_reservasi.setVisibility(View.GONE);
            rekamedikEditText.setVisibility(View.GONE);
            namapasienEditText.setVisibility(View.GONE);
            pilihtanggalEditText.setVisibility(View.GONE);
            pilihjamEditText.setVisibility(View.GONE);
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
