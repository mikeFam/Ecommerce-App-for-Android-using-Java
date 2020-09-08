package com.example.myapplication;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.Brand;

import java.util.List;

public class brandAdaptor extends RecyclerView.Adapter<brandAdaptor.My2ViewHolder> {

    private Context context;
    private List<Brand> brands;


    public brandAdaptor(Context context, List<Brand> brands) {
        this.context = context;
        this.brands = brands;
    }

    public class My2ViewHolder extends RecyclerView.ViewHolder {
        TextView mName;
        ImageView mImage;
        LinearLayout parentListLayout;

        public My2ViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name);
            mImage = itemView.findViewById(R.id.image);
            parentListLayout = itemView.findViewById(R.id.parentBrandList_layout);
        }
    }


    @NonNull
    @Override
    public My2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.brand_list,parent,false);

        return new My2ViewHolder(v);
    }




    @Override
    public void onBindViewHolder(@NonNull My2ViewHolder holder, int position) {

        final Brand brand = brands.get(position);

        holder.mName.setText(brand.getName());
        holder.mImage.setImageResource(brand.getImage());

        holder.parentListLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BrandListActivity.class);
                intent.putExtra("name", brand.getName());
                intent.putExtra("image", brand.getImage());
                intent.putExtra("id",brand.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return brands.size();
    }

}
