package com.formaltech.rsudoganilir;

import android.os.Parcel;
import android.os.Parcelable;

public class RoomItem implements Parcelable {
    private String nama, terisi, kosong;

    RoomItem(String nama, String terisi, String kosong) {
        this.nama = nama;
        this.terisi = terisi;
        this.kosong = kosong;
    }

    String getNama() {
        return nama;
    }

    String getTerisi() {
        return terisi;
    }

    String getKosong() {
        return kosong;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nama);
        parcel.writeString(this.terisi);
        parcel.writeString(this.kosong);
    }

    private RoomItem(Parcel in) {
        this.nama = in.readString();
        this.terisi = in.readString();
        this.kosong = in.readString();
    }

    public static final Parcelable.Creator<RoomItem> CREATOR = new Parcelable.Creator<RoomItem>() {

        @Override
        public RoomItem createFromParcel(Parcel source) {
            return new RoomItem(source);
        }

        @Override
        public RoomItem[] newArray(int size) {
            return new RoomItem[size];
        }
    };
}
