package com.example.abdelrahman.qrbarcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import me.dm7.barcodescanner.zbar.ZBarScannerView;

public class ScanActivity extends AppCompatActivity implements ZBarScannerView.ResultHandler {
    private ZBarScannerView mScannerView;

    //camera permission is needed.

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZBarScannerView(this);    // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera(); // Start camera on resume
        mScannerView.findFocus();
//        mScannerView.setFlash(true);
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.setFlash(false);
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(me.dm7.barcodescanner.zbar.Result result) {
        // Do something with the result here
        Log.v("kkkk", result.getContents()); // Prints scan results
        Log.v("uuuu", result.getBarcodeFormat().getName()); // Prints the scan format (qrcode, pdf417 etc.)


        ScanActivity0.tvresult.setText(result.getContents());
        onBackPressed();

        // If you would like to resume scanning, call this method below:
        //mScannerView.resumeCameraPreview(this);
    }

    public void openFlash (View view){
        mScannerView.setFlash(true);
    }
}
