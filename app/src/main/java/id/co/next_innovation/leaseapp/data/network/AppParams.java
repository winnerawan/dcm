package id.co.next_innovation.leaseapp.data.network;

import android.util.Base64;

import javax.inject.Singleton;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */

@Singleton
public class AppParams {

    static {
        System.loadLibrary("native-lib");
    }

//    public native String invokeParamAuthentication();
//    public native String invokeParamRegister();
//    public native String invokeParamSaldo();
//    public native String invokeParamSimpanan();
//    public native String invokeParamSimpananByJenis();
//    public native String invokeParamPinjaman();
//
//    public String authentication = new String(Base64.decode(invokeParamAuthentication(), Base64.DEFAULT));
//    public String register = new String(Base64.decode(invokeParamRegister(), Base64.DEFAULT));
//    public String saldo = new String(Base64.decode(invokeParamSaldo(), Base64.DEFAULT));
//    public String simpanan = new String(Base64.decode(invokeParamSimpanan(), Base64.DEFAULT));
//    public String jenis_simpanan = new String(Base64.decode(invokeParamSimpananByJenis(), Base64.DEFAULT));
//    public String pinjaman = new String(Base64.decode(invokeParamPinjaman(), Base64.DEFAULT));

}
