package Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sinhvien.hotel_project.Edit_Hotel;
import com.sinhvien.hotel_project.Host;
import com.sinhvien.hotel_project.R;

import java.util.ArrayList;
import java.util.List;

import Domain.Hoteldb;


public class Rec_Hotel_Adapter extends RecyclerView.Adapter<Rec_Hotel_Adapter.ViewHolder> {
    private Context context;
    private Activity activity;
    private ArrayList id, codehotel,nameHotel, cityHotel, addrHotel, desHotel, servHotel, policyHotel, childbedHotel, importantinforHotel;
    private ArrayList<Hoteldb> hoteldbArrayList;

    public Rec_Hotel_Adapter(Context context, Activity activity, ArrayList id, ArrayList codehotel, ArrayList nameHotel, ArrayList cityHotel, ArrayList addrHotel, ArrayList desHotel, ArrayList servHotel, ArrayList policyHotel, ArrayList childbedHotel, ArrayList importantinforHotel) {
        this.context = context;
        this.activity = activity;
        this.id = id;
        this.codehotel = codehotel;
        this.nameHotel = nameHotel;
        this.cityHotel = cityHotel;
        this.addrHotel = addrHotel;
        this.desHotel = desHotel;
        this.servHotel = servHotel;
        this.policyHotel = policyHotel;
        this.childbedHotel = childbedHotel;
        this.importantinforHotel = importantinforHotel;
    }

    public Rec_Hotel_Adapter(Context context, Activity activity, ArrayList<Hoteldb> hoteldbArrayList) {
        this.context = context;
        this.activity = activity;
        this.hoteldbArrayList = hoteldbArrayList;
    }

    @NonNull
    @Override
    public Rec_Hotel_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_hotel, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Rec_Hotel_Adapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        //holder.Namehotel.setText(items.get(position).getHotel_name());
        //holder.CityHotel.setText(items.get(position).getHotel_city());
        holder.Namehotel.setText(String.valueOf(nameHotel.get(position)));
        holder.CityHotel.setText(String.valueOf(cityHotel.get(position)));
        //Glide.with(context).load(items.get(position).getImage_hotel()).into(holder.Rec_pic);
        holder.cardHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Edit_Hotel.class);
                intent.putExtra("id", String.valueOf(id.get(position)));
                intent.putExtra("code", String.valueOf(codehotel.get(position)));
                intent.putExtra("name", String.valueOf(nameHotel.get(position)));
                intent.putExtra("city", String.valueOf(cityHotel.get(position)));
                intent.putExtra("addr", String.valueOf(addrHotel.get(position)));
                intent.putExtra("des", String.valueOf(desHotel.get(position)));
                intent.putExtra("serv", String.valueOf(servHotel.get(position)));
                intent.putExtra("policy", String.valueOf(policyHotel.get(position)));
                intent.putExtra("childbed", String.valueOf(childbedHotel.get(position)));
                intent.putExtra("important", String.valueOf(importantinforHotel.get(position)));

                activity.startActivityForResult(intent, 1);
            }
        });

        //int drawableId = holder.itemView.getResources().getIdentifier(items.get(position).getRec_pic(), "drawable",holder.itemView.getContext().getPackageName());
        //Glide.with(holder.itemView.getContext()).load(drawableId).transform(new CenterCrop(), new GranularRoundedCorners(40,40, 40,40)).into(holder.Rec_pic);
    }

    /*
    @Override
    public void onBindViewHolder(@NonNull Rec_Hotel_Adapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        //holder.Namehotel.setText(items.get(position).getHotel_name());
        //holder.CityHotel.setText(items.get(position).getHotel_city());
        holder.Namehotel.setText(hoteldbArrayList.get(position).getHotel_name());
        holder.CityHotel.setText(hoteldbArrayList.get(position).getHotel_city());
        //Glide.with(context).load(items.get(position).getImage_hotel()).into(holder.Rec_pic);
        holder.cardHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Edit_Hotel.class);
                intent.putExtra("id", String.valueOf(hoteldbArrayList.get(position).getId()));
                intent.putExtra("code", String.valueOf(hoteldbArrayList.get(position).getHotel_code()));
                intent.putExtra("name", String.valueOf(hoteldbArrayList.get(position).getHotel_name()));
                intent.putExtra("city", String.valueOf(hoteldbArrayList.get(position).getHotel_city()));
                intent.putExtra("addr", String.valueOf(hoteldbArrayList.get(position).getHotel_Addrr()));
                intent.putExtra("des", String.valueOf(hoteldbArrayList.get(position).getHotel_Des()));
                intent.putExtra("serv", String.valueOf(hoteldbArrayList.get(position).getHotel_Service()));
                intent.putExtra("policy", String.valueOf(hoteldbArrayList.get(position).getHotel_Policy()));
                intent.putExtra("childbed", String.valueOf(hoteldbArrayList.get(position).getChild_And_Bed_Policy()));
                intent.putExtra("important", String.valueOf(hoteldbArrayList.get(position).getHotel_ImportantInfor()));

                activity.startActivityForResult(intent, 1);
            }
        });

        //int drawableId = holder.itemView.getResources().getIdentifier(items.get(position).getRec_pic(), "drawable",holder.itemView.getContext().getPackageName());
        //Glide.with(holder.itemView.getContext()).load(drawableId).transform(new CenterCrop(), new GranularRoundedCorners(40,40, 40,40)).into(holder.Rec_pic);
    }*/

    @Override
    public int getItemCount() {
        return id.size();
    }

    public void SearchData(){

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Namehotel, CityHotel;
        //ImageView Rec_pic;
        CardView cardHotel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Namehotel = itemView.findViewById(R.id.Hotel_name);
            CityHotel = itemView.findViewById(R.id.City);

            cardHotel = itemView.findViewById(R.id.card_hotel);
        }
    }

}
