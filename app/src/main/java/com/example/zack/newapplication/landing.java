package com.example.zack.newapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class landing extends AppCompatActivity {
    Firebase ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        Firebase.setAndroidContext(this);
        ref = new Firebase("https://dazzling-torch-8082.firebaseio.com/");
        Firebase displayRef = ref.child("Messages");
        displayRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                retrieveMessage displayStuff = snapshot.getValue(retrieveMessage.class);
                TextView displayed = (TextView)findViewById(R.id.display);
                String doDisplay = displayed.getText().toString();
                displayed.setText(doDisplay + "\n" + displayStuff.getMessage());


            }
            @Override
            public void onChildChanged(DataSnapshot snapshot, String previousChildKey) {

            }
            @Override
            public void onChildRemoved(DataSnapshot snapshot) {

            }
            @Override
            public void onChildMoved(DataSnapshot snapshot, String previousChildKey){

            }
            @Override public void onCancelled(FirebaseError firebaseError){

            }
        });

    }
}
