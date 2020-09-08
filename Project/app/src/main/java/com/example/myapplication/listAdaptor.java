package com.example.myapplication;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.Shoe;

import java.util.List;

public class listAdaptor extends RecyclerView.Adapter<listAdaptor.MyViewHolder> {

    private Context context;
    private List<Shoe> shoes;

    public listAdaptor(Context context, List<Shoe> shoes) {
        this.context = context;
        this.shoes = shoes;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mName,mPrice;
        ImageView mImage;
        LinearLayout parentListLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name);
            mPrice = itemView.findViewById(R.id.price);
            mImage = itemView.findViewById(R.id.image);
            parentListLayout = itemView.findViewById(R.id.parentList_layout);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Shoe shoe = shoes.get(position);

        holder.mName.setText(shoe.getName());
        holder.mPrice.setText("$ " + String.valueOf(shoe.getPrice()));
        holder.mImage.setImageResource(shoe.getImage());

        holder.parentListLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("name", shoe.getName());
                intent.putExtra("image", shoe.getImage());
                intent.putExtra("price",shoe.getPrice());
                intent.putExtra("photos",shoe.getPhotos());
                intent.putExtra("brand",shoe.getBrand());
                intent.putExtra("description",shoe.getDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shoes.size();
    }


}
