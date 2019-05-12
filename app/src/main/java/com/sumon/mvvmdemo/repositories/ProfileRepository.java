package com.sumon.mvvmdemo.repositories;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.sumon.mvvmdemo.db.DbHandler;
import com.sumon.mvvmdemo.db.ProfileModel;

import java.util.ArrayList;

public class ProfileRepository {
    private static final String TAG = "ProfileRepository";
    // Access a Cloud Firestore instance from your Activity
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference documentReference = db.document("store_name/app_name");

    private static ProfileRepository instance;
    private ArrayList<ProfileModel> profileModel = new ArrayList<>();
    private MutableLiveData<ArrayList<ProfileModel>> profiles = new MutableLiveData<>();


    public static ProfileRepository getInstance() {
        if (instance == null) {
            instance = new ProfileRepository();
        }
        return instance;
    }

    public MutableLiveData<ArrayList<ProfileModel>> getProfileModel() {
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                  //  Toast.makeText(ProfileActivity.this, "Error while loading!", Toast.LENGTH_LONG).show();
                    Log.d(TAG, e.toString());
                    return;
                }

                if (snapshot.exists()) {
                    DbHandler note = snapshot.toObject(DbHandler.class);
                    assert note != null;
                    if(!note.getResponse().isEmpty() ){
                        profiles.setValue(note.getResponse());
                    }else {
                        _addToFirestore();
                    }

                }
            }
        });
       // setProfiles();

        return profiles;
    }

    private void _addToFirestore() {
        ArrayList<ProfileModel> list = new ArrayList<>();
        list.add(new ProfileModel("Demo Node", "Demo Node"));
        list.add(new ProfileModel("Demo Node", "Demo Node"));
        DbHandler note = new DbHandler(list);

        documentReference.set(note);

    }


    private void setProfiles() {
        profileModel.add(new ProfileModel("sumon", "hasan"));
        profileModel.add(new ProfileModel("sumon", "hasan"));
        profileModel.add(new ProfileModel("sumon", "hasan"));
        profileModel.add(new ProfileModel("sumon", "hasan"));
    }
}