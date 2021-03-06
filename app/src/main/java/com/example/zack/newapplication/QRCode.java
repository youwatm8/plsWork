package com.example.zack.newapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.firebase.client.Firebase;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class QRCode extends Activity implements OnClickListener {
    private Button scanBtn;
    private Firebase ref;
    private Button reset;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        ref = new Firebase("https://dazzling-torch-8082.firebaseio.com/");
        setContentView(R.layout.activity_qrcode);
        scanBtn = (Button)findViewById(R.id.scan_button);

        scanBtn.setOnClickListener(this);
        reset = (Button)findViewById(R.id.reset);
        reset.setOnClickListener(this);
    }

    public void onClick(View v){
//respond to clicks

        if(v.getId()==R.id.scan_button){
//scan

            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
        else if(v.getId()==R.id.reset){
            Firebase resetRef = ref.child("Classes").child("Hamby");
            resetRef.child("Zack").setValue("Absent");
        }
    }
    void editData(String name){
        Firebase changeRef = ref.child("Classes").child(name);
        changeRef.child("Zack").setValue("Present");
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
//retrieve scan result
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanningResult != null) {
//we have a result
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            editData(scanContent);
        } else{
                Toast toast = Toast.makeText(getApplicationContext(),
                        "No scan data received!", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

