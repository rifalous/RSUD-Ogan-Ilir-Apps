package com.formaltech.rsudoganilir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MedicineActivity extends AppCompatActivity {

    String[] names = {
            "Aipi",
            "Alopurinol",
            "Amoxilin",
            "Antimo",
            "Betadine",
            "Bodrex",
            "Bodrexin",
            "Cendo Xitrol",
            "CTM",
            "Mixagrip",
            "Natur-E",
            "Paracetamol",
            "Ponstan",
            "Promag",
            "Sacred Water"
    };

    String[] satuan = {
            "Strip",
            "Strip",
            "Strip",
            "Strip",
            "Strip",
            "Botol",
            "Dos",
            "Strip",
            "Botol",
            "Pcs",
            "Pcs",
            "Strip",
            "Strip",
            "Strip",
            "Strip"
    };

    String[] stok = {
            "84",
            "65",
            "81",
            "70",
            "22",
            "68",
            "25",
            "26",
            "42",
            "50",
            "33",
            "61",
            "24",
            "16",
            "15"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

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
            view = getLayoutInflater().inflate(R.layout.medicine_list_item, null);

            TextView namaObat = (TextView)view.findViewById(R.id.medicine_nama);
            TextView satuanObat = (TextView)view.findViewById(R.id.medicine_satuan);
            TextView stokObat = (TextView)view.findViewById(R.id.medicine_stok);

            namaObat.setText(names[i]);
            satuanObat.setText(satuan[i]);
            stokObat.setText(stok[i]);

            return view;
        }
    }
}
