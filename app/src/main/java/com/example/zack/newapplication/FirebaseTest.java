package com.example.zack.newapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.Firebase;

public class FirebaseTest extends AppCompatActivity {
    private static final String firebaseURL = "https://dazzling-torch-8082.firebaseio.com";
    private Firebase ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_test);
        Firebase.setAndroidContext(this);
        ref = new Firebase(firebaseURL);
    }
}
