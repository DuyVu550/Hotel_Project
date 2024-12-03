package com.sinhvien.hotel_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Home_Admin extends AppCompatActivity {

    ImageView AdminHotel, AdminRoom, ManageAccount, AdminBooking, AdminPayment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);
        AdminHotel = (ImageView) findViewById(R.id.adminhotel);
        AdminRoom = (ImageView) findViewById(R.id.adminroom);
        AdminBooking = (ImageView) findViewById(R.id.adminbooking);
        ManageAccount = (ImageView) findViewById(R.id.manageAccount);
        AdminPayment = (ImageView) findViewById(R.id.adminpayment);

        AdminHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHotel =  new Intent(Home_Admin.this, Manage_hotel.class);
                startActivity(intentHotel);
            }
        });
    }
}