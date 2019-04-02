package com.formaltech.rsudoganilir;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

/**
 * Created by Rifal on 14/03/2019.
 */
public class OnBoardActivity extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Slider 1
        addFragment(new Step.Builder().setTitle("Cek Jadwal Dokter")
                .setContent("Cek Jadwal Dokter yang Tersedia Berdasarkan Jam Praktik dan Poli Asalnya.")
                .setBackgroundColor(Color.parseColor("#324cad")) // int background color
                .setDrawable(R.drawable.onboardingdoctor) // int top drawable
                .setSummary("")
                .build());


        //Slider 2
        addFragment(new Step.Builder().setTitle("Cek Ketersediaan Kamar RSUD")
                .setContent("Cek Ketersediaan Kamar yang Kosong untuk Layanan Rawat Inap")
                .setBackgroundColor(Color.parseColor("#324cad")) // int background color
                .setDrawable(R.drawable.onboardingroom) // int top drawable
                .setSummary("")
                .build());


        //Slider 4
        addFragment(new Step.Builder().setTitle("Reservasi")
                .setContent("Lakukan Reservasi Antrian Berobat Pada Menu Reservasi")
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
