#Play Services Barcode Scanner

* Uses Vision SDK from Play Services 8.1.0

Sample app shows the usage of the barcode reader from play services.

##Steps:

* Copy package `barcodereader` into your packages.
* Copy the layout file `activity_barcode_capture.xml` into layouts.
* Declare the `BarcodeCaptureActivity` in AndroidManifest and Also add `CAMERA` permission in it.
* To invoke Scanner, write the below piece of code.

```
      Intent intent = new Intent(this, BarcodeCaptureActivity.class);
      intent.putExtra(BarcodeCaptureActivity.AutoFocus, true);
      intent.putExtra(BarcodeCaptureActivity.UseFlash, false);
      //Specify what type of barcode to look for.
      intent.putExtra(BarcodeCaptureActivity.CodeType, Barcode.QR_CODE);

      startActivityForResult(intent, BARCODE_CAPTURE_REQUEST_CODE);
```

* To accept the scan result, write the below piece of code in `onActivityResult` method.

```
    if(requestCode == BARCODE_CAPTURE_REQUEST_CODE && resultCode == RESULT_OK){
        /**
         * You will receive the scan result in the below extra parameter.
         * The value will be string which can be then casted to json or any other type.
         */
        String barcodeScanValue = data.getStringExtra(BarcodeCaptureActivity.BARCODE_VALUE);
        mScanValue.setText(barcodeScanValue);
    }
```

That's it. You can then play around with the scanned data.

Write to me@hannanshaik.com for any queries.

Reference: https://github.com/googlesamples/android-vision