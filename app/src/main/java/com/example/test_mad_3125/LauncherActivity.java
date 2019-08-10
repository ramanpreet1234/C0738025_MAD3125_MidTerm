package com.example.test_mad_3125;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("Registered")
public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        final Context context = this;

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(Exception ex){
                    Toast.makeText(context, "Something went wrong",Toast.LENGTH_LONG).show();
                }finally {
                    finish();
                    startActivity(new Intent(context,LoginActivity.class));
                }
            }
        };

        timer.start();
    }

    public void onClick(View view) {

    }
}
