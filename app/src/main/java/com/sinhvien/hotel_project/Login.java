package com.sinhvien.hotel_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.sinhvien.hotel_project.databinding.ActivityUnloghostBinding;

import Database_Hotel.MyDatabase;

public class Login extends AppCompatActivity {
    SharedPreferences pref;
    MyDatabase database;
    EditText username, password;
    TextView to_register;
    RadioButton chkUser, chkAdmin;
    Button btnLog;
    final String AdminUser = "Admin2004";
    final String AdminPass = "Admin2004";

    private static final String PREF_NAME = "LOGIN";
    private static final String KEY_NAME = "name";
    private static final String KEY_PASS = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        database = new MyDatabase(Login.this);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnLog = (Button) findViewById(R.id.btn_login);
        to_register = (TextView) findViewById(R.id.to_register);
        chkAdmin = (RadioButton) findViewById(R.id.chkAdmin);
        chkUser = (RadioButton) findViewById(R.id.chkUser);

        pref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        String name = pref.getString(KEY_NAME, null);
        if(name != null){
            Intent intent = new Intent(Login.this, Host.class);
            startActivity(intent);
        }



        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username, Password;
                Username = username.getText().toString();
                Password = password.getText().toString();
                SharedPreferences.Editor editor = pref.edit();
                editor.putString(KEY_NAME, Username);
                editor.putString(KEY_PASS, Password);
                editor.commit();
                if(username.equals("") || password.equals("")){
                    Toast.makeText(Login.this, "Phải điền hết phiên còn trống", Toast.LENGTH_SHORT).show();
                }else {
                    if(database.CheckAccount(Username, Password) && chkUser.isChecked()){

                        Intent intent = new Intent(Login.this, Host.class);
                        startActivity(intent);
                        Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                        finish();

                    }
                    if(chkAdmin.isChecked() && Username.equals(AdminUser) && Password.equals(AdminPass)){
                        Intent intentAdmin = new Intent(Login.this, Home_Admin.class);
                        startActivity(intentAdmin);
                        Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(Login.this, "Tên người dùng hoặc mật khẩu không đúng hoặc chọn sai vị trí", Toast.LENGTH_LONG).show();
                    }
                    if(!chkUser.isChecked() || !chkAdmin.isChecked()){
                        Toast.makeText(Login.this, "Phải chọn vị trí của mình", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }

}