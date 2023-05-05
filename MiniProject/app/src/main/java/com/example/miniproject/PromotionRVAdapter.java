package com.example.miniproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PromotionRVAdapter extends RecyclerView.Adapter<PromotionRVAdapter.ViewHolder> {

    int lastpos = -1;
    private ArrayList<PromotionParcel> promotionParcelArrayList;
    private Context context;
    private PromotionClickInterface promotionClickInterface;

    public PromotionRVAdapter(ArrayList<PromotionParcel> promotionParcelArrayList, Context context, PromotionClickInterface promotionClickInterface) {
        this.promotionParcelArrayList = promotionParcelArrayList;
        this.context = context;
        this.promotionClickInterface = promotionClickInterface;
    }

    @NonNull
    @Override
    public PromotionRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.promotion_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionRVAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        PromotionParcel promotionParcel = promotionParcelArrayList.get(position);

        holder.promotionTitleTV.setText(promotionParcel.getPromotionTitle());
        holder.promotionContentTV.setText(promotionParcel.getPromotionContent());
        holder.businessNameTV.setText(promotionParcel.getBusinessName());
        holder.promotionStartDateTV.setText("시작일 - " + promotionParcel.getPromotionStartDate());
        holder.promotionEndDateTV.setText("종료일 - " + promotionParcel.getPromotionEndDate());

        if (promotionParcel.getPhoto1() != null) {
            holder.photo1IV.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.get().load(promotionParcel.getPhoto1()).into(holder.photo1IV);
        }
        if (promotionParcel.getPhoto2() != null) {
            holder.photo2IV.setVisibility(View.VISIBLE);
            holder.photo2IV.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.get().load(promotionParcel.getPhoto2()).into(holder.photo2IV);
        }
        if (promotionParcel.getPhoto3() != null) {
            holder.photo3IV.setVisibility(View.VISIBLE);
            holder.photo3IV.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.get().load(promotionParcel.getPhoto3()).into(holder.photo3IV);
        }
        if (promotionParcel.getPhoto4() != null) {
            holder.photo4IV.setVisibility(View.VISIBLE);
            holder.photo4IV.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.get().load(promotionParcel.getPhoto4()).into(holder.photo4IV);
        }

        setAnimation(holder.itemView, position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                promotionClickInterface.onPromotionClick(position);
            }
        });
    }

    private void setAnimation(View itemView, int position) {
        if (position > lastpos) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            itemView.setAnimation(animation);
            lastpos = position;
        }
    }

    @Override
    public int getItemCount() {
        return promotionParcelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView promotionTitleTV, promotionContentTV, businessNameTV, promotionStartDateTV, promotionEndDateTV;
        private ImageView photo1IV, photo2IV, photo3IV, photo4IV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //init
            promotionTitleTV = itemView.findViewById(R.id.idTVPromotionTitle);
            promotionContentTV = itemView.findViewById(R.id.idTVPromotionContent);
            businessNameTV = itemView.findViewById(R.id.idTVBusinessName);
            promotionStartDateTV = itemView.findViewById(R.id.idTVPromotionStartDate);
            promotionEndDateTV = itemView.findViewById(R.id.idTVPromotionEndDate);
            photo1IV = itemView.findViewById(R.id.idIVPhoto1);
            photo2IV = itemView.findViewById(R.id.idIVPhoto2);
            photo3IV = itemView.findViewById(R.id.idIVPhoto3);
            photo4IV = itemView.findViewById(R.id.idIVPhoto4);
        }
    }

    public interface PromotionClickInterface {
        void onPromotionClick(int position);
    }
}
