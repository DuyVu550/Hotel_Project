package com.sinhvien.hotel_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import Database_Hotel.MyDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile_HaveAccount_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile_HaveAccount_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView username, logout;
    MyDatabase database;
    private static final String KEY_NAME = "name";
    private static final String PREF_NAME = "LOGIN";
    SharedPreferences sharedPreferences;

    public Profile_HaveAccount_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Profile_HaveAccount_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Profile_HaveAccount_Fragment newInstance(String param1, String param2) {
        Profile_HaveAccount_Fragment fragment = new Profile_HaveAccount_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile__have_account_, container, false);
        username = view.findViewById(R.id.displayusername);
        logout = view.findViewById(R.id.txtlogout);
        //database = new MyDatabase(getContext());
        //database.DisplayUser(username.toString());

        sharedPreferences = getActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NAME, null);
        if(name != null){
            username.setText(name);
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(getContext(), "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), Login.class);
                startActivity(intent);
            }
        });

        return view;
    }


}