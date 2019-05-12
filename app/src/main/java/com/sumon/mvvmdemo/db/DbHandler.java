package com.sumon.mvvmdemo.db;

import java.util.ArrayList;

public class DbHandler {
    private ArrayList<ProfileModel> response = new ArrayList<>();

    public DbHandler() {
    }

    public DbHandler(ArrayList<ProfileModel> response) {
        this.response = response;
    }

    public ArrayList<ProfileModel> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<ProfileModel> response) {
        this.response = response;
    }
}
