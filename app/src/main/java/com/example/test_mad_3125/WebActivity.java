package com.example.test_mad_3125;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("Registered")
public class WebActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        WebView webManual = findViewById(R.id.webManual);
        webManual.loadUrl("https://en.wikipedia.org/wiki/Trailblazer_%28satellite%29");

    }
}
