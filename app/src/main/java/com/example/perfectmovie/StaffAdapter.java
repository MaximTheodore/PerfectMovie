package com.example.perfectmovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.StaffViewHolder> {

    private ArrayList<Staff> staff;
    private Context context;

    public StaffAdapter(Context context, ArrayList<Staff> staff){
        this.context = context;
        this.staff = staff;
    }

    @NonNull
    @Override
    public StaffAdapter.StaffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.staff_card, parent, false);
        return new StaffAdapter.StaffViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaffAdapter.StaffViewHolder holder, int position) {
        Staff staff1 = staff.get(position);
        Picasso.with(holder.itemView.getContext()).load(staff1.getPosterUrl()).into(holder.img);
        holder.txt.setText(staff1.getNameRu()+"/\n "+staff1.getNameEn());
    }

    @Override
    public int getItemCount() {
        return staff.size();
    }

    public class StaffViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        public StaffViewHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.staff_name);
            img = itemView.findViewById(R.id.staff_poster);
        }
    }
}
