package com.sinhvien.hotel_project;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import Database_Hotel.Database_HT;
import Database_Hotel.MyDatabase;
import Domain.Hoteldb;

public class Edit_Hotel extends AppCompatActivity {

    EditText editCodeHotel, editNameHotel, editCityHotel, editAddrHotel, editDesHotel, editServiceHotel, editPolicyHotel, editChildrenAndBed, editImportantInforHotel;
    Button edit, delete;
    String id,codehotel, namehotel, cityhotel, addrhotel, deshotel, servhotel, policyhotel, childbedhotel, importantinfothotel;
    MyDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hotel);

        editCodeHotel = findViewById(R.id.editHotelCode);
        editNameHotel = findViewById(R.id.editNameHotel);
        editCityHotel = findViewById(R.id.editCityHotel);
        editAddrHotel = findViewById(R.id.editHotelAddress);
        editDesHotel = findViewById(R.id.editHotelDes);
        editServiceHotel = findViewById(R.id.editHotelService);
        editPolicyHotel = findViewById(R.id.editHotelPolicy);
        editChildrenAndBed = findViewById(R.id.editHotelPolicyOf_BedandChildren);
        editImportantInforHotel = findViewById(R.id.editHotelImportantInfor);
        edit = findViewById(R.id.editBtn);
        delete = findViewById(R.id.deleteBtn);

        getData();
        database = new MyDatabase(Edit_Hotel.this);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codehotel = editCodeHotel.getText().toString();
                namehotel = editNameHotel.getText().toString();
                cityhotel = editCityHotel.getText().toString();
                addrhotel = editAddrHotel.getText().toString();
                deshotel = editDesHotel.getText().toString();
                servhotel = editServiceHotel.getText().toString();
                policyhotel = editPolicyHotel.getText().toString();
                childbedhotel = editChildrenAndBed.getText().toString();
                importantinfothotel = editImportantInforHotel.getText().toString();
                Hoteldb hoteldb = new Hoteldb(id,codehotel,namehotel,cityhotel,addrhotel,deshotel,servhotel,policyhotel,childbedhotel,importantinfothotel);
                database.updateHotel(hoteldb);

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
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

            editCodeHotel.setText(codehotel);
            editNameHotel.setText(namehotel);
            editCityHotel.setText(cityhotel);
            editAddrHotel.setText(addrhotel);
            editServiceHotel.setText(servhotel);
            editDesHotel.setText(deshotel);
            editPolicyHotel.setText(policyhotel);
            editChildrenAndBed.setText(childbedhotel);
            editImportantInforHotel.setText(importantinfothotel);
        }else {
            Toast.makeText(Edit_Hotel.this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    public  void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xóa "+ namehotel + " ?");
        builder.setMessage("Bạn có muốn xóa " + namehotel + " ?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Hoteldb hoteldb = new Hoteldb(id,codehotel,namehotel,cityhotel,addrhotel,deshotel,servhotel,policyhotel,childbedhotel,importantinfothotel);
                database.deleteHotel(hoteldb);
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }
}