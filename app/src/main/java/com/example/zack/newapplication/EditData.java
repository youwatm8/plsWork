package com.example.zack.newapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.Firebase;

public class EditData extends AppCompatActivity {
    private Firebase ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_edit_data);
        ref = new Firebase("https://dazzling-torch-8082.firebaseio.com/");
        editData();

    }
    void editData(){
        Firebase changeRef = ref.child("Classes").child("Hamby");
        changeRef.child("Zack").setValue("Present");
    }
}
