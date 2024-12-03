package com.sinhvien.hotel_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LayoutHotel extends AppCompatActivity {

    TextView NameHotel, AddrHotel, DesHotel, ServiceHotel, PolicyHotel, ChildrenAndBed, ImportantInforHotel;
    String id,codehotel, namehotel, cityhotel, addrhotel, deshotel, servhotel, policyhotel, childbedhotel, importantinfothotel;
    Button btnContact, btnRate, btnChooseRoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_hotel);

        NameHotel = findViewById(R.id.txtNameHotel);
        AddrHotel = findViewById(R.id.txtDirectionHotel);
        DesHotel = findViewById(R.id.txtDescriptionHotel);
        ServiceHotel = findViewById(R.id.txtServiceHotel);
        PolicyHotel = findViewById(R.id.txtPolicyHotel);
        ChildrenAndBed = findViewById(R.id.txtChildrenAndBed);
        ImportantInforHotel = findViewById(R.id.txtImportantInfor);
        btnContact = (Button) findViewById(R.id.btnCon);
        btnRate = (Button) findViewById(R.id.btnRate);
        getData();
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LayoutHotel.this, Contact.class);
                startActivity(intent);
            }
        });

    }



    public void getData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("city") && getIntent().hasExtra("addr") && getIntent().hasExtra("des") && getIntent().hasExtra("serv")
                && getIntent().hasExtra("policy") && getIntent().hasExtra("childbed") && getIntent().hasExtra("important")){
            id = getIntent().getStringExtra("id");
            codehotel = getIntent().getStringExtra("code");
            namehotel = getIntent().getStringExtra("name");
            cityhotel = getIntent().getStringExtra("city");
            addrhotel = getIntent().getStringExtra("addr");
            servhotel = getIntent().getStringExtra("serv");
            deshotel = getIntent().getStringExtra("des");
            policyhotel = getIntent().getStringExtra("policy");
            childbedhotel = getIntent().getStringExtra("childbed");
            importantinfothotel = getIntent().getStringExtra("important");

            NameHotel.setText(namehotel);
            AddrHotel.setText(addrhotel);
            ServiceHotel.setText(servhotel);
            DesHotel.setText(deshotel);
            PolicyHotel.setText(policyhotel);
            ChildrenAndBed.setText(childbedhotel);
            ImportantInforHotel.setText(importantinfothotel);
        }else {
            Toast.makeText(LayoutHotel.this, "No data", Toast.LENGTH_SHORT).show();
        }
    }



}