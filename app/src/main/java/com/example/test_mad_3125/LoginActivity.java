package com.example.test_mad_3125;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test_mad_3125.MainActivity;
import com.example.test_mad_3125.R;

@SuppressLint("Registered")
public class LoginActivity  extends AppCompatActivity implements View.OnClickListener{

    Button btnLogin;
    Button btnRegister;
    EditText edtEmail;
    EditText edtPassword;
    com.example.test.DBHelper dbHelper;
    SQLiteDatabase ParkingDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);

        dbHelper = new com.example.test.DBHelper(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == btnLogin.getId()){

            if (verifyLogin()){
                Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show();

                finish();
                startActivity(new Intent(this, SpaceActivity.class));
            }else{
                Toast.makeText(this,"Invalid username/password",Toast.LENGTH_LONG).show();
            }


        }else if(view.getId() == btnRegister.getId()){
            Toast.makeText(this,"Creating an account",Toast.LENGTH_LONG).show();

            finish();
            Intent signUpIntent = new Intent(this, com.example.test_mad_3125.SignUpActivity.class);
            startActivity(signUpIntent);
        }
    }

    private boolean verifyLogin(){
        try{
            ParkingDB = dbHelper.getReadableDatabase();
            String columns[] = {"Email", "Password"};
            String userData[] = {edtEmail.getText().toString(), edtPassword.getText().toString()};

            Cursor cursor = ParkingDB.query("UserInfo",columns,
                    "Email = ? AND Password = ?",userData,
                    null,null,null);

            if(cursor != null){
                if(cursor.getCount() > 0){
                    return true;
                }
            }

            return false;

        }catch(Exception e){
            Log.e("LoginActivity", e.getMessage());
            return false;
        }finally {
            ParkingDB.close();
        }
    }
}
