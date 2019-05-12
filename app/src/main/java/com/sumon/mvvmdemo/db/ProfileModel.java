package com.sumon.mvvmdemo.db;

public class ProfileModel {
    // firestore data source
    // define node name
    String a, b;

    public ProfileModel() {
    }

    public ProfileModel(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

}
