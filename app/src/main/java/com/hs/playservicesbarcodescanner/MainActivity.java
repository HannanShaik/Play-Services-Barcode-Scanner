package com.hs.playservicesbarcodescanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.vision.barcode.Barcode;
import com.hs.playservicesbarcodescanner.barcodereader.BarcodeCaptureActivity;

import static com.hs.playservicesbarcodescanner.barcodereader.BarcodeCaptureActivity.BARCODE_CAPTURE_REQUEST_CODE;

public class MainActivity extends AppCompatActivity {

    private TextView mScanValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScanValue = (TextView) findViewById(R.id.tv_scan_result);
    }

    /**
     * This method will invoke the barcode scanner activity which will capture the barcode
     * and return back with the value.
     * @param view
     */
    public void doScan(View view) {
        Intent intent = new Intent(this, BarcodeCaptureActivity.class);
        intent.putExtra(BarcodeCaptureActivity.AutoFocus, true);
        intent.putExtra(BarcodeCaptureActivity.UseFlash, false);
        //Specify what type of barcode to look for.
        intent.putExtra(BarcodeCaptureActivity.CodeType, Barcode.QR_CODE);

        startActivityForResult(intent, BARCODE_CAPTURE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == BARCODE_CAPTURE_REQUEST_CODE && resultCode == RESULT_OK){
            /**
             * You will receive the scan result in the below extra parameter.
             * The value will be string which can be then casted to json or any other type.
             */
            String barcodeScanValue = data.getStringExtra(BarcodeCaptureActivity.BARCODE_VALUE);
            mScanValue.setText(barcodeScanValue);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
