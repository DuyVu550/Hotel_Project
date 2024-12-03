package Adapter;

import android.annotation.SuppressLint;
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
import com.sinhvien.hotel_project.LayoutHotel;
import com.sinhvien.hotel_project.R;

import java.util.ArrayList;

public class HotelForUser_Adapter extends RecyclerView.Adapter<HotelForUser_Adapter.ViewHolder> {

    private Context context;
    private ArrayList id, codehotel,nameHotel, cityHotel, addrHotel, desHotel, servHotel, policyHotel, childbedHotel, importantinforHotel;

    public HotelForUser_Adapter(Context context, ArrayList id, ArrayList codehotel, ArrayList nameHotel, ArrayList cityHotel, ArrayList addrHotel, ArrayList desHotel, ArrayList servHotel, ArrayList policyHotel, ArrayList childbedHotel, ArrayList importantinforHotel) {
        this.context = context;
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

    @NonNull
    @Override
    public HotelForUser_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_hotel, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelForUser_Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.Namehotel.setText(String.valueOf(nameHotel.get(position)));
        holder.CityHotel.setText(String.valueOf(cityHotel.get(position)));

        holder.cardHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LayoutHotel.class);
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

                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return id.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Namehotel, CityHotel;
        //ImageView Rec_pic;
        CardView cardHotel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Namehotel = itemView.findViewById(R.id.Hotel_name);
            CityHotel = itemView.findViewById(R.id.City);

            cardHotel = itemView.findViewById(R.id.cardviewHotelUser);
        }
    }
}
