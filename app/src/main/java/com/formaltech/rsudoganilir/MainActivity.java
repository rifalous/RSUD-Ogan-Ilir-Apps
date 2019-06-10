package com.formaltech.rsudoganilir;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cvDoctor = findViewById(R.id.cvDoctor);
        CardView cvFacilities = findViewById(R.id.cvFacilities);
        CardView cvRoom = findViewById(R.id.cvRoom);
        CardView cvReservation = findViewById(R.id.cvReservation);
        CardView cvContact = findViewById(R.id.cvContact);
        CardView cvAbout = findViewById(R.id.cvAbout);

        cvDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DoctorActivity.class));
            }
        });

        cvFacilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FacilitiesActivity.class));
            }
        });

        cvRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RoomActivity.class));
            }
        });

        cvReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        cvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }
        });

        cvContact.setOnClickListener(new View.OnClickListener() {
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
    //- Button Tapped Effect (Done)
    //- Activity Transition Effect
    //- Implement Pull Refresh	(Doing)
    //- Implement JSON API display into ListView with Custom Adapter (Ruangan)	(Doing)
    //- Date & Time Picker (Done)
    //- Optimize Facilities Layout (Done)
    //- Replace Medicine with Facilty (Done)
    //- Design Reservation Menu Screen	(Done)
    //- Modify Doctor, Room Screen	    (Done)
    //- Implement Check Internet Connection	(Done)
    //- Remove All Warning Signs (Extract Strings)	(Done)
    //- Lock All Screen to Portrait	    (Done)
    //- Application/Launcher Icon	(Done)
    //- Add Back Button on Toolbar	(Done)
    //- Implement double tap to exit (Done)

}
