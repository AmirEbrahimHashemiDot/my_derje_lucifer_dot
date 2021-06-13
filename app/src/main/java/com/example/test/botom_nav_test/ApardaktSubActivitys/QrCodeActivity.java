package com.example.test.botom_nav_test.ApardaktSubActivitys;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.example.test.botom_nav_test.MainMenuActivitys.AmaliatPardaktActivity;
import com.example.test.botom_nav_test.R;
import com.google.zxing.Result;

public class QrCodeActivity extends AppCompatActivity {

    Button btn_goto_amaliat_from_qrcode;

    private static final int REQUEST_PERMISSION_CODE = 1001;
    private CodeScanner mcodeScanner;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);


        getPermission();
        setUpViewsEvents();
        /*if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_PERMISSION_CODE);
            } else {
                decodeQRCode();
            }
        } else {
            decodeQRCode();
        }*/
    }

    private void getPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_PERMISSION_CODE);
            } else {
                decodeQRCode();
            }
        } else {
            decodeQRCode();
        }
    }

    private void setUpViewsEvents() {
        btn_goto_amaliat_from_qrcode = (Button)findViewById(R.id.btn_goto_amaliat_from_qrcode);
        btn_goto_amaliat_from_qrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QrCodeActivity.this, AmaliatPardaktActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION_CODE && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();
            decodeQRCode();
        } else {
            Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QrCodeActivity.this, AmaliatPardaktActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void decodeQRCode() {

        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        mcodeScanner = new CodeScanner(this, scannerView);
        mcodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Toast.makeText(QrCodeActivity.this, result.getText(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_VIEW);
                            intent.addCategory(Intent.CATEGORY_BROWSABLE);
                            String url = result.getText();
                            intent.setData(Uri.parse(url));
                            startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.i("Error_in_load_uri", e.getMessage());
                            Toast.makeText(getApplicationContext(), result.getText(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcodeScanner.startPreview();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                mcodeScanner.startPreview();
            } /*else {
                Toast.makeText(getApplicationContext(), "problem onResume", Toast.LENGTH_SHORT).show();
            }*/
        } else {
            mcodeScanner.startPreview();
        }
    }

    @Override
    protected void onPause() {

        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                mcodeScanner.releaseResources();
            } /*else {
                Toast.makeText(getApplicationContext(), "problem onResume", Toast.LENGTH_SHORT).show();
            }*/
        } else {
            mcodeScanner.releaseResources();
        }


        super.onPause();
    }
}
