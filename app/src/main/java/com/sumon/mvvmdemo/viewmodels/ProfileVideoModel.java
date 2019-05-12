package com.sumon.mvvmdemo.viewmodels;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.sumon.mvvmdemo.db.ProfileModel;
import com.sumon.mvvmdemo.repositories.ProfileRepository;

import java.util.ArrayList;

public class ProfileVideoModel extends ViewModel {
    private MutableLiveData<ArrayList<ProfileModel>> profiles;

    public void init(){
        if (profiles != null){
            return;
        }
        ProfileRepository repository = ProfileRepository.getInstance();
        profiles = repository.getProfileModel();
    }

    public LiveData<ArrayList<ProfileModel>> getProfiles() {
        return profiles;
    }
}
