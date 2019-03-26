package com.formaltech.rsudoganilir;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class OnBoardActivity extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //slider 1
        addFragment(new Step.Builder().setTitle("Cek Dokter yang Tersedia")
                .setContent("Cek Dokter yang Tersedia Berdasarkan Jam dan Poli Asalnya.")
                .setBackgroundColor(Color.parseColor("#324cad")) // int background color
                .setDrawable(R.drawable.onboardingdoctor) // int top drawable
                .setSummary("")
                .build());

        //slider 2
        addFragment(new Step.Builder().setTitle("Cek Ketersediaan Stok Obat")
                .setContent("Cek Ketersediaan Stok Obat berdasarkan Nama/Jenis Obatnya.")
                .setBackgroundColor(Color.parseColor("#324cad")) // int background color
                .setDrawable(R.drawable.onboardingmedicine) // int top drawable
                .setSummary("")
                .build());


        //slider 3
        addFragment(new Step.Builder().setTitle("Cek Ketersediaan Kamar Rumah Sakit")
                .setContent("Cek Ketersediaan Kamar yang Kosong untuk Rawat Inap")
                .setBackgroundColor(Color.parseColor("#324cad")) // int background color
                .setDrawable(R.drawable.onboardingroom) // int top drawable
                .setSummary("")
                .build());


        //slider 4
        addFragment(new Step.Builder().setTitle("Registrasi Antrian")
                .setContent("Lakukan Registrasi Antrian Pada Menu Registrasi")
                .setBackgroundColor(Color.parseColor("#324cad")) // int background color
                .setDrawable(R.drawable.onboardingregist) // int top drawable
                .setSummary("")
                .build());
    }

    @Override
    public void finishTutorial() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void currentFragmentPosition(int i) {

    }

}
