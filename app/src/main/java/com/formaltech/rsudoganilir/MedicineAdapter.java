package com.formaltech.rsudoganilir;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rifal on 14/03/2019.
 */
public class MedicineAdapter extends ArrayAdapter<MedicineItem> {

    private List<MedicineItem> medicineItemList;

    private Context context;

    MedicineAdapter(List<MedicineItem> medicineItemList, Context context) {
        super(context, R.layout.medicine_list_item, medicineItemList);
        this.medicineItemList = medicineItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        @SuppressLint("ViewHolder") View listViewItem = inflater.inflate(R.layout.medicine_list_item, null, true);
        TextView textNamaObat = listViewItem.findViewById(R.id.medicine_nama);
        TextView textSatuanObat = listViewItem.findViewById(R.id.medicine_satuan);
        TextView textStokObat = listViewItem.findViewById(R.id.medicine_stok);


        MedicineItem medicineItem = medicineItemList.get(position);

        textNamaObat.setText(medicineItem.getNama());
        textSatuanObat.setText(medicineItem.getSatuan());
        textStokObat.setText(medicineItem.getStok());

        return listViewItem;
    }
}
