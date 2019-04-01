package com.formaltech.rsudoganilir;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.Objects;

/**
 * Created by Rifal on 14/03/2019.
 */
public class AboutActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView title, version, subtitle1, subtitle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);

        title = findViewById(R.id.title);
        version = findViewById(R.id.version);
        subtitle1 = findViewById(R.id.subtitle1);
        subtitle2 = findViewById(R.id.subtitle2);

        title.setTypeface(MMedium);
        subtitle1.setTypeface(MMedium);
        subtitle2.setTypeface(MMedium);
        version.setTypeface(MMedium);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
