package com.sinhvien.hotel_project;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.appsearch.StorageInfo;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.jar.Attributes;

import Adapter.Rec_Hotel_Adapter;
import Database_Hotel.MyDatabase;
import Domain.Hoteldb;

public class Upload_Hotel extends AppCompatActivity {

    ImageView uploadimg;
    EditText CodeHotel, NameHotel, CityHotel, AddrHotel, DesHotel, ServiceHotel, PolicyHotel, ChildrenAndBed, ImportantInforHotel;
    Button Save;
    Uri uri;
    ArrayList<Uri> Arrayuri = new ArrayList<>();
    Rec_Hotel_Adapter adapter;
    MyDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_hotel);

        CodeHotel = (EditText) findViewById(R.id.uploadHotelCode);
        NameHotel = (EditText) findViewById(R.id.uploadNameHotel);
        CityHotel = (EditText) findViewById(R.id.uploadCityHotel);
        AddrHotel = (EditText) findViewById(R.id.uploadHotelAddress);
        DesHotel = (EditText) findViewById(R.id.uploadHotelDes);
        ServiceHotel = (EditText) findViewById(R.id.uploadHotelService);
        PolicyHotel = (EditText) findViewById(R.id.uploadHotelPolicy);
        ChildrenAndBed = (EditText) findViewById(R.id.uploadHotelPolicyOf_BedandChildren);
        ImportantInforHotel = (EditText) findViewById(R.id.uploadHotelImportantInfor);
        uploadimg = (ImageView) findViewById(R.id.uploadImage);
        Save = (Button) findViewById(R.id.saveBtn);


        database = new MyDatabase(Upload_Hotel.this);

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            uri = data.getData();
                            uploadimg.setImageURI(uri);
                        }else{
                            Toast.makeText(Upload_Hotel.this, "No Image found.", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

        uploadimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                activityResultLauncher.launch(intent);
            }
        });



        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code, name, city, addr, des, service, policy, childrenandbed, importantinfor;
                code = CodeHotel.getText().toString();
                name = NameHotel.getText().toString();
                addr = AddrHotel.getText().toString();
                city = CityHotel.getText().toString();
                des = DesHotel.getText().toString();
                service = ServiceHotel.getText().toString();
                policy = PolicyHotel.getText().toString();
                childrenandbed = ChildrenAndBed.getText().toString();
                importantinfor = ImportantInforHotel.getText().toString();

                if(code.equals("") || name.equals("") || addr.equals("") || city.equals("") || des.equals("") || service.equals("") || policy.equals("") || childrenandbed.equals("") || importantinfor.equals("")){
                    Toast.makeText(Upload_Hotel.this, "Phải điền hết những phiên còn trống", Toast.LENGTH_LONG).show();
                }else {

                    Hoteldb hotel = new Hoteldb(code, name, addr, city, des, service, policy, childrenandbed, importantinfor);
                    database.insertHotel(hotel);
                    Intent intentManageHotel = new Intent(Upload_Hotel.this, Manage_hotel.class);
                    startActivity(intentManageHotel);
                    Toast.makeText(Upload_Hotel.this, "Lưu thành công", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    /*@Override
    protected void onActivityResult(int requestcode, int resultcode, @Nullable Intent data) {
        super.onActivityResult(requestcode, resultcode, data);

        if(requestcode == 1  && resultcode == Activity.RESULT_OK){
            if(data.getClipData()!= null){
                Uri imageUri = data.getClipData().getItemAt(1).getUri();
                uri.add(imageUri);
            }
            adapter.notifyDataSetChanged();

        }
    }*/


}