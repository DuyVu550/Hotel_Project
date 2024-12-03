package com.sinhvien.hotel_project;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import Adapter.Rec_Hotel_Adapter;
import Database_Hotel.MyDatabase;
import Domain.Hoteldb;
import Domain.Recommend_Hotel;

public class Manage_hotel extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerViewHotel;
    SearchView searchView;
    MyDatabase myDatabase;
    Rec_Hotel_Adapter hotelAdapter;
    ArrayList<Hoteldb> hoteldb;
    ArrayList<String> idhotel, codehotel, namehotel, cityhotel, addrhotel, deshotel, servicehotel, policyhotel, childbedhotel, importantinforhotel;
    String  idhotels, codehotels, namehotels, cityhotels, addrhotels, deshotels, servicehotels, policyhotels, childbedhotels, importantinforhotels;
    private static final int Read_permission = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_hotel);
        recyclerViewHotel = (RecyclerView) findViewById(R.id.adminHotel_recycleView);
        searchView = (SearchView) findViewById(R.id.search_adminHotel);
        //hoteldb = new ArrayList<>();
        myDatabase = new MyDatabase(Manage_hotel.this);
        idhotel = new ArrayList<>();
        namehotel = new ArrayList<>();
        cityhotel = new ArrayList<>();
        codehotel = new ArrayList<>();
        addrhotel = new ArrayList<>();
        deshotel = new ArrayList<>();
        servicehotel = new ArrayList<>();
        policyhotel = new ArrayList<>();
        childbedhotel = new ArrayList<>();
        importantinforhotel = new ArrayList<>();
        //hoteldb.add(new Hoteldb(idhotels, codehotels, namehotels, cityhotels, addrhotels, deshotels, servicehotels, policyhotels, childbedhotels, importantinforhotels));
        DisplayDataArray();

        hotelAdapter = new Rec_Hotel_Adapter(this, Manage_hotel.this, idhotel, codehotel, namehotel, cityhotel, addrhotel, deshotel, servicehotel, policyhotel, childbedhotel, importantinforhotel);
        recyclerViewHotel.setAdapter(hotelAdapter);
        recyclerViewHotel.setLayoutManager(new LinearLayoutManager(Manage_hotel.this));

        fab = (FloatingActionButton) findViewById(R.id.add_hotel);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Manage_hotel.this, Upload_Hotel.class);
                startActivity(intent);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase(Locale.ROOT);
                String name = newText;
                if(name.contains(newText)){
                    recyclerViewHotel.setAdapter(hotelAdapter);
                    DisplaySingleData();
                }

                return true;
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void DisplayDataArray(){
        Cursor cursor = myDatabase.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(Manage_hotel.this, "No data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                idhotel.add(cursor.getString(0));
                codehotel.add(cursor.getString(1));
                namehotel.add(cursor.getString(2));
                cityhotel.add(cursor.getString(3));
                addrhotel.add(cursor.getString(4));
                deshotel.add(cursor.getString(5));
                servicehotel.add(cursor.getString(6));
                policyhotel.add(cursor.getString(7));
                childbedhotel.add(cursor.getString(8));
                importantinforhotel.add(cursor.getString(9));
            }
        }
    }

    void DisplaySingleData(){
        Cursor cursor = myDatabase.readSingleData(String.valueOf(namehotel));
        if(cursor.getCount() == 0){
            Toast.makeText(Manage_hotel.this, "No data", Toast.LENGTH_SHORT).show();
        }else {
            idhotel.add(cursor.getString(0));
            codehotel.add(cursor.getString(1));
            namehotel.add(cursor.getString(2));
            cityhotel.add(cursor.getString(3));
            addrhotel.add(cursor.getString(4));
            deshotel.add(cursor.getString(5));
            servicehotel.add(cursor.getString(6));
            policyhotel.add(cursor.getString(7));
            childbedhotel.add(cursor.getString(8));
            importantinforhotel.add(cursor.getString(9));

        }
    }

}