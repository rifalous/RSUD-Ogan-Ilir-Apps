package com.formaltech.rsudoganilir;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hololo.tutorial.library.PermissionStep;
import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class OnBoardActivity extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //slider 1
        addFragment(new Step.Builder().setTitle("This is header 1")
                .setContent("This is content 1")
                .setBackgroundColor(Color.parseColor("#CAE1FF")) // int background color
                .setDrawable(R.drawable.img1) // int top drawable
                .setSummary("This is summary 1")
                .build());

        //slider 2
        addFragment(new Step.Builder().setTitle("This is header 2")
                .setContent("This is content 2")
                .setBackgroundColor(Color.parseColor("#CAE1FF")) // int background color
                .setDrawable(R.drawable.img2) // int top drawable
                .setSummary("This is summary 2")
                .build());


        //slider 3
        addFragment(new Step.Builder().setTitle("This is header 3")
                .setContent("This is content 3")
                .setBackgroundColor(Color.parseColor("#CAE1FF")) // int background color
                .setDrawable(R.drawable.img3) // int top drawable
                .setSummary("This is summary 3")
                .build());


        //slider 4
        addFragment(new Step.Builder().setTitle("This is header 4")
                .setContent("This is content 4")
                .setBackgroundColor(Color.parseColor("#CAE1FF")) // int background color
                .setDrawable(R.drawable.img4) // int top drawable
                .setSummary("This is summary 4")
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
