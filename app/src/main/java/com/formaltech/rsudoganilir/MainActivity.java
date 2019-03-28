package com.formaltech.rsudoganilir;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView btnDoctor = findViewById(R.id.doctor);
        ImageView btnMedicine = findViewById(R.id.medicine);
        ImageView btnRoom = findViewById(R.id.room);
        ImageView btnRegist = findViewById(R.id.regist);
        ImageView btnContact = findViewById(R.id.contact);
        ImageView btnAbout = findViewById(R.id.about);

        btnDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DoctorActivity.class));
            }
        });

        btnMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MedicineActivity.class));
            }
        });

        btnRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RoomActivity.class));
            }
        });

        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContactActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan tombol 'back' lagi untuk keluar", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    //Todo:
    //- Design Reservation Menu Screen	(To Do)
    //- Replace Medicine with Facilty (To Do)
    //- Implement Pull Refresh	(Doing)
    //- Implement JSON API display into ListView with Custom Adapter (Dokter, Kamar, Obat)	(Doing)
    //- Date & Time Picker (To Do)
    //- Modify Doctor, Room Screen	    (Done)
    //- Implement Check Internet Connection	(Done)
    //- Remove All Warning Signs (Extract Strings)	(Done)
    //- Lock All Screen to Portrait	    (Done)
    //- Application/Launcher Icon	(Done)
    //- Add Back Button on Toolbar	(Done)
    //- Implement double tap to exit (Done)

}
