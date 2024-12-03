package com.sinhvien.hotel_project;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import Database_Hotel.MyDatabase;

public class BookingRoom extends AppCompatActivity {
    MyDatabase database;
    EditText phone, adult, children,checkin, checkout, ho, ten;
    TextView hotel, room, codebook;
    Button booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_room);
        database = new MyDatabase(BookingRoom.this);
        ho = (EditText) findViewById(R.id.edit_hobook);
        ten = (EditText) findViewById(R.id.edit_tenbook);
        checkin = (EditText) findViewById(R.id.Checkin);
        checkout = (EditText) findViewById(R.id.Checkout);
        phone = (EditText) findViewById(R.id.edit_Phone);
        adult = (EditText) findViewById(R.id.editTextAdult);
        children = (EditText) findViewById(R.id.editTextChildren);
        hotel = (TextView) findViewById(R.id.BookingHotel);
        room = (TextView) findViewById(R.id.BookingRoom);
        codebook = (TextView) findViewById(R.id.codebook);
        booking = (Button) findViewById(R.id.btn_bookingroom);

        codebook.setText(getRandomString(10));


        checkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DATE);

                DatePickerDialog datePickerDialog = new DatePickerDialog(BookingRoom.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        checkin.setText(year + "/" + (month+1) + "/" + dayOfMonth);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DATE);

                DatePickerDialog datePickerDialog = new DatePickerDialog(BookingRoom.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        checkin.setText(year + "/" + (month+1) + "/" + dayOfMonth);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });


        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("hotelbook", String.valueOf(hotel));
                intent.putExtra("roombook", String.valueOf(room));
                intent.putExtra("codebook", String.valueOf(codebook));
                intent.putExtra("hobook", String.valueOf(ho));
                intent.putExtra("tenbook", String.valueOf(ten));
                intent.putExtra("phone", String.valueOf(phone));
                intent.putExtra("checkin", String.valueOf(checkin));
                intent.putExtra("checkout", String.valueOf(checkout));
            }
        });
    }

    public static String getRandomString(int i){
        final String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        while (i > 0){
            Random random = new Random();
            stringBuilder.append(characters.charAt(random.nextInt(characters.length())));
            i--;
        }
        return stringBuilder.toString();
    }

}