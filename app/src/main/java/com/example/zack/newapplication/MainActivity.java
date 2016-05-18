package com.example.zack.newapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {
    private static final String FIREBASE_URl = "https://dazzling-torch-8082.firebaseio.com/";

    private Firebase firebaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        firebaseRef = new Firebase(FIREBASE_URl);

        EditText inputText = (EditText) findViewById(R.id.messageText);
    }
}
