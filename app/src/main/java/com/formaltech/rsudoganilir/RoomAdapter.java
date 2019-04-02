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

public class RoomAdapter extends ArrayAdapter<RoomItem> {

    private List<RoomItem> roomItemList;

    private Context context;

    RoomAdapter(List<RoomItem> roomItemList, Context context) {
        super(context, R.layout.room_list_item, roomItemList);
        this.roomItemList = roomItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        @SuppressLint("ViewHolder") View listViewItem = inflater.inflate(R.layout.room_list_item, null, true);
        TextView textNamaKamar = listViewItem.findViewById(R.id.room_nama);
        TextView textTerisi = listViewItem.findViewById(R.id.room_terisi);
        TextView textKosong = listViewItem.findViewById(R.id.room_kosong);


        RoomItem roomItem = roomItemList.get(position);

        textNamaKamar.setText(roomItem.getNama());
        textTerisi.setText(roomItem.getTerisi());
        textKosong.setText(roomItem.getKosong());

        return listViewItem;
    }
}
