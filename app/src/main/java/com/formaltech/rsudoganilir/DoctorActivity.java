package com.formaltech.rsudoganilir;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
            "12.00",
            "13.00",
            "14.00",
            "15.00",
            "16.00",
            "17.00"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.listView);
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

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.doctor_list_item, null);

            ImageView mImageView = (ImageView)view.findViewById(R.id.imageDoctor);

            TextView namaDokter = (TextView)view.findViewById(R.id.doctor_nama);
            TextView poliDokter = (TextView)view.findViewById(R.id.doctor_poli);
            TextView jamDokter = (TextView)view.findViewById(R.id.doctor_jam);

            mImageView.setImageResource(images[i]);
            namaDokter.setText(names[i]);
            poliDokter.setText(poli[i]);
            jamDokter.setText(jam[i]);

            return view;
        }
    }
}
