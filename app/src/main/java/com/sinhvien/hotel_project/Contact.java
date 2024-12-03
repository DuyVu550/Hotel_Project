package com.sinhvien.hotel_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import Database_Hotel.MyDatabase;

public class Contact extends AppCompatActivity {
    Button btngui;
    EditText edthoi, edtmail;
    SharedPreferences pref;
    MyDatabase database;
    private static final String CAU_HOI = "cauhoi";
    private static final String Email = "email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contact);
        btngui = (Button) findViewById(R.id.btngui);
        edthoi = (EditText) findViewById(R.id.cauhoi);
        edtmail = (EditText) findViewById(R.id.email2);
        btngui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cauhoi, email;
                cauhoi = edthoi.getText().toString();
                email = edtmail.getText().toString();
                database.insertContact(cauhoi, email);
                Toast.makeText(Contact.this, "Liên hệ được gửi đi thành công", Toast.LENGTH_SHORT).show();
            }
        });

    }
}