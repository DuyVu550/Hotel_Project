package com.sinhvien.hotel_project;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sinhvien.hotel_project.databinding.ActivityRegisterBinding;

import Database_Hotel.Database_HT;
import Database_Hotel.MyDatabase;
import Domain.Account;

public class Register extends AppCompatActivity {

    EditText userName, userHo, userTen, userEmail, userPass, userRepass;
    Button btnRegister, btnLogin;
    MyDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userName = (EditText) findViewById(R.id.username);
        userHo = (EditText) findViewById(R.id.ho);
        userTen = (EditText) findViewById(R.id.ten);
        userEmail = (EditText) findViewById(R.id.email);
        userPass = (EditText) findViewById(R.id.password);
        userRepass = (EditText) findViewById(R.id.repassword);
        btnRegister = (Button) findViewById(R.id.btn_register);
        btnLogin = (Button) findViewById(R.id.btn_login);

        database = new MyDatabase(Register.this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user, useremail, userho, userten, userpass, userrepass;
                user = userName.getText().toString();
                useremail = userEmail.getText().toString();
                userho = userHo.getText().toString();
                userten = userTen.getText().toString();
                userpass = userPass.getText().toString();
                userrepass = userRepass.getText().toString();

                if(userpass.equals(userrepass)){
                    if(userpass.length() > 8){
                        if(database.CheckUser(user)){
                            Toast.makeText(Register.this, "Tên tài khoản đã tồn tại", Toast.LENGTH_LONG).show();
                            return;
                        }
                        database.insertAccount(user, userho, userten, useremail, userpass, userrepass);
                        Intent intentLog = new Intent(Register.this, Login.class);
                        startActivity(intentLog);
                        Toast.makeText(Register.this, "Đăng ký thành công", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(Register.this, "Mật khẩu phải trên 8 ký tự", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(Register.this, "Mật khẩu không hợp lệ", Toast.LENGTH_LONG).show();
                }
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentlog = new Intent(Register.this, Login.class);
                startActivity(intentlog);
            }
        });


    }

}