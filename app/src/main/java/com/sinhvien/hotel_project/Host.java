package com.sinhvien.hotel_project;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;


import com.sinhvien.hotel_project.databinding.ActivityUnloghostBinding;

public class Host extends AppCompatActivity {

    ActivityUnloghostBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUnloghostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFracment(new HomeFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.btnHome){
                replaceFracment(new HomeFragment());

            } else if (item.getItemId() == R.id.btnLike) {
                replaceFracment(new LikeFragment());
            } else if (item.getItemId() == R.id.btnLuggage) {
                replaceFracment(new BookFragment());
            } else if (item.getItemId() == R.id.btnAccount) {
                replaceFracment(new Profile_HaveAccount_Fragment());
            }


            return true;
        });



    }

    private void replaceFracment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

}