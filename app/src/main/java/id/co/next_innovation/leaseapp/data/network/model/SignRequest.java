package id.co.next_innovation.leaseapp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class SignRequest {

    private SignRequest() {

    }

    public static class In {
        @Expose
        @SerializedName("kode")
        private String kode;

        public In(String kode) {
            this.kode = kode;
        }

        public String getKode() {
            return kode;
        }

        public void setKode(String kode) {
            this.kode = kode;
        }
    }

    public static class Up {
        @Expose
        @SerializedName("kode")
        private String kode;
        @Expose
        @SerializedName("nama")
        private String nama;
        @Expose
        @SerializedName("alamat")
        private String alamat;
        @Expose
        @SerializedName("hp")
        private String hp;
        @Expose
        @SerializedName("keanggotaan_id")
        private String keanggotaan_id;

        public Up(String kode, String nama, String alamat, String hp, String keanggotaan_id) {
            this.kode = kode;
            this.nama = nama;
            this.alamat = alamat;
            this.hp = hp;
            this.keanggotaan_id = keanggotaan_id;
        }

        public String getKode() {
            return kode;
        }

        public void setKode(String kode) {
            this.kode = kode;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getAlamat() {
            return alamat;
        }

        public void setAlamat(String alamat) {
            this.alamat = alamat;
        }

        public String getHp() {
            return hp;
        }

        public void setHp(String hp) {
            this.hp = hp;
        }

        public String getKeanggotaan_id() {
            return keanggotaan_id;
        }

        public void setKeanggotaan_id(String keanggotaan_id) {
            this.keanggotaan_id = keanggotaan_id;
        }
    }
}
