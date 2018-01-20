package id.co.next_innovation.leaseapp.data.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */

@Entity(nameInDb = "customers")
public class Customer {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nopol")
    @Expose
    private String nopol;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("thn")
    @Expose
    private Integer thn;
    @SerializedName("warna")
    @Expose
    private String warna;
    @SerializedName("noka")
    @Expose
    private String noka;
    @SerializedName("nosin")
    @Expose
    private String nosin;
    @SerializedName("pk")
    @Expose
    private String pk;
    @SerializedName("stnk")
    @Expose
    private String stnk;
    @SerializedName("bank")
    @Expose
    private String bank;
    @SerializedName("cabang")
    @Expose
    private String cabang;

    @Generated(hash = 1651496261)
    public Customer(Integer id, String nopol, String unit, Integer thn,
            String warna, String noka, String nosin, String pk, String stnk,
            String bank, String cabang) {
        this.id = id;
        this.nopol = nopol;
        this.unit = unit;
        this.thn = thn;
        this.warna = warna;
        this.noka = noka;
        this.nosin = nosin;
        this.pk = pk;
        this.stnk = stnk;
        this.bank = bank;
        this.cabang = cabang;
    }

    @Generated(hash = 60841032)
    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getThn() {
        return thn;
    }

    public void setThn(Integer thn) {
        this.thn = thn;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getNoka() {
        return noka;
    }

    public void setNoka(String noka) {
        this.noka = noka;
    }

    public String getNosin() {
        return nosin;
    }

    public void setNosin(String nosin) {
        this.nosin = nosin;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getStnk() {
        return stnk;
    }

    public void setStnk(String stnk) {
        this.stnk = stnk;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCabang() {
        return cabang;
    }

    public void setCabang(String cabang) {
        this.cabang = cabang;
    }

}
