package com.formaltech.rsudoganilir;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Objects;

/**
 * Created by Rifal on 14/03/2019.
 */
public class DoctorActivity extends AppCompatActivity {

    int[] images = {
            R.drawable.doctor1,
            R.drawable.doctor2,
            R.drawable.doctor3,
            R.drawable.doctor4,
            R.drawable.doctor5,
            R.drawable.doctor6
    };

    String[] names = {
            "John",
            "Sasha",
            "Lucianne",
            "Cindy",
            "Rose",
            "Mike"
    };

    String[] poli = {
            "Poliklinik Gigi",
            "Poliklinik Anak",
            "Poliklinik Bedah",
            "Poliklinik Umum",
            "Poliklinik Saraf",
            "Poliklinik Mata"
    };

    String[] jam = {
            "08.00 - 12.00",
            "09.00 - 14.00",
            "09.00 - 14.00",
            "09.30 - 14.30",
            "11.00 - 16.00",
            "10.30 - 16.00"
    };

    Toolbar toolbar;
    ListView listView;
    ImageView mImageView;
    TextView namaDokter, poliDokter, jamDokter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listView = findViewById(R.id.listView);
        listView.setDivider(null);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint({"ViewHolder", "InflateParams"})
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.doctor_list_item, null);

            mImageView = view.findViewById(R.id.imageDoctor);
            namaDokter = view.findViewById(R.id.doctor_nama);
            poliDokter = view.findViewById(R.id.doctor_poli);
            jamDokter = view.findViewById(R.id.doctor_jam);

            mImageView.setImageResource(images[i]);
            namaDokter.setText(names[i]);
            poliDokter.setText(poli[i]);
            jamDokter.setText(jam[i]);

            return view;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
