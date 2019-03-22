package com.formaltech.rsudoganilir;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MedicineActivity extends AppCompatActivity {
    /*  CUSTOM ADAPTER + JSON API
    public class MedicineActivity  extends AppCompatActivity {


        private static final String JSON_URL = "https://rifalous.github.io/Pandora-Box/medicine.json";


        ListView listView;
        private List<MedicineItem> medicineItemList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            listView =  findViewById(R.id.listView);
            medicineItemList = new ArrayList<>();



            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    MedicineItem medicineItem = medicineItemList.get(position);

                    Intent i = new Intent(getApplicationContext(), DetailMedicineActivity.class);
                    i.putExtra(DetailMedicineActivity.EXTRA_MEDICINE, medicineItem);
                    startActivity(i);


                }
            });
            loadPlayer();
        }

        private void loadPlayer() {
            StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject obj = new JSONObject(response);
                                JSONArray playerArray = obj.getJSONArray("obat");

                                for (int i = 0; i < playerArray.length(); i++) {

                                    JSONObject playerObject = playerArray.getJSONObject(i);


                                    MedicineItem medicineItem = new MedicineItem(playerObject.getString("nama"),
                                            playerObject.getString("satuan"),
                                            playerObject.getString("stok"));

                                    medicineItemList.add(medicineItem);
                                }

                                ListViewAdapter adapter = new ListViewAdapter(medicineItemList, getApplicationContext());

                                listView.setAdapter(adapter);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        }
    }*/

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
            "Botol",
            "Strip",
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

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
