package com.healthifymeal.healthifymeal;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    ArrayList<FeaturedHelper> featured;

    public FeaturedAdapter(ArrayList<FeaturedHelper> featured) {
        this.featured = featured;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design,parent,false);

        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);

        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        FeaturedHelper featuredHelper = featured.get(position);
        holder.image.setImageResource(featuredHelper.getImage());
        holder.title.setText(featuredHelper.getTitle());
        holder.desc.setText(featuredHelper.getDesc());
    }

    @Override
    public int getItemCount() {
        return featured.size();
    }


    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;


        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.featured_image1);
            title = itemView.findViewById(R.id.featured_title1);
            desc = itemView.findViewById(R.id.featured_desc1);




        }
    }


}
