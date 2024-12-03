package com.sinhvien.hotel_project;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import Adapter.HotelForUser_Adapter;
import Adapter.PopularAdapter;
import Adapter.Rec_Hotel_Adapter;
import Database_Hotel.MyDatabase;
import Domain.PopularDomain;
import Domain.Recommend_Hotel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private RecyclerView.Adapter adapterPopular;
    private RecyclerView recycleviewPopular;
    private RecyclerView.Adapter adapterRec_hotel;
    private RecyclerView recyclerViewRec_hotel;
    RecyclerView recyclerView;
    MyDatabase myDatabase;
    HotelForUser_Adapter hotelForUserAdapter;
    ArrayList<String> idhotel, codehotel, namehotel, cityhotel, addrhotel, deshotel, servicehotel, policyhotel, childbedhotel, importantinforhotel;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.viewpop2);
        myDatabase = new MyDatabase(getContext());
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

        DisplayDataArray();

        hotelForUserAdapter = new HotelForUser_Adapter( getContext(),idhotel, codehotel, namehotel, cityhotel, addrhotel, deshotel, servicehotel, policyhotel, childbedhotel, importantinforhotel);
        recyclerView.setAdapter(hotelForUserAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        return view;
    }

    void DisplayDataArray(){
        Cursor cursor = myDatabase.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(getContext(), "No data", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Hồ Chí Minh", "tphcm"));
        items.add(new PopularDomain("Hà Nội", "hanoi"));
        items.add(new PopularDomain("Vũng Tàu", "vungtau"));
        items.add(new PopularDomain("Đà lạt", "dalat"));
        items.add(new PopularDomain("Huế", "hue"));

        recycleviewPopular = view.findViewById(R.id.viewpop);
        recycleviewPopular.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        adapterPopular = new PopularAdapter(items);
        recycleviewPopular.setAdapter(adapterPopular);


    }

}