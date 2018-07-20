package com.example.abdelrahman.qrbarcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void StartScanActivity (View view){
        Intent intent = new Intent(this,ScanActivity0.class);
        startActivity(intent);
    }

    public void StartGenerateActivity (View view){
        Intent intent = new Intent(this,GenerateActivity.class);
        startActivity(intent);
    }
}
