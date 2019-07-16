package com.formaltech.rsudoganilir;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rifal on 14/03/2019.
 */
public class MedicineItem implements Parcelable {
    private String nama, satuan, stok;

    MedicineItem(String nama, String satuan, String stok) {
        this.nama = nama;
        this.satuan = satuan;
        this.stok = stok;
    }

    String getNama() {
        return nama;
    }

    String getSatuan() {
        return satuan;
    }

    String getStok() {
        return stok;
    }

    /*
    public void setNama(String satuan) {
        this.nama = satuan;
    }

    public void setSatuan(String nama) {
        this.satuan = nama;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }*/

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nama);
        parcel.writeString(this.satuan);
        parcel.writeString(this.stok);
    }

    /*
    public MedicineItem(){
    }
    */

    private MedicineItem(Parcel in) {
        this.nama = in.readString();
        this.satuan = in.readString();
        this.stok = in.readString();
    }

    public static final Parcelable.Creator<MedicineItem> CREATOR = new Parcelable.Creator<MedicineItem>() {

        @Override
        public MedicineItem createFromParcel(Parcel source) {
            return new MedicineItem(source);
        }

        @Override
        public MedicineItem[] newArray(int size) {
            return new MedicineItem[size];
        }
    };
}
