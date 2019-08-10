package com.example.test_mad_3125;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SpaceActivity extends AppCompatActivity {

    ListView lstReport;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        lstReport = findViewById(R.id.lstReport);
        lstReport.setAdapter(new SpaceAdapter(getApplicationContext()));
    }
}




