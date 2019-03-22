package com.formaltech.rsudoganilir;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Objects;

public class RoomActivity extends AppCompatActivity {

    String[] names = {
            "Kamar Melati",
            "Kamar Mawar",
            "Kamar Cempaka",
            "Kamar Dahlia",
            "Kamar Anggrek",
            "Kamar Bougenville",
            "Kamar Lili",
            "Kamar Teratai",
            "Kamar Flamboyan"
    };

    String[] terisi = {
            "7",
            "2",
            "6",
            "4",
            "5",
            "7",
            "8",
            "9",
            "10"
    };

    String[] kosong = {
            "3",
            "8",
            "4",
            "6",
            "5",
            "3",
            "2",
            "1",
            "0"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setDivider(null);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.length;
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
            view = getLayoutInflater().inflate(R.layout.room_list_item, null);

            TextView namaKamar = (TextView)view.findViewById(R.id.room_nama);
            TextView terisiKamar = (TextView)view.findViewById(R.id.room_terisi);
            TextView kosongKamar = (TextView)view.findViewById(R.id.room_kosong);

            namaKamar.setText(names[i]);
            terisiKamar.setText(terisi[i]);
            kosongKamar.setText(kosong[i]);

            return view;
        }
    }
    
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
