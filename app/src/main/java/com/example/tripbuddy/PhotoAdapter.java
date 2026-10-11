package com.example.tripbuddy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    private Context context;
    private List<PhotoItem> photoItemList;
    private int[] imageIds;
    public PhotoAdapter(Context context, List<PhotoItem>photoItemList) {
        this.context = context;
        this.photoItemList = photoItemList;

    }

    public PhotoAdapter(Gallery context, int[] photoItemList) {
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_photo_item,parent, false);

        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        PhotoItem Item = photoItemList.get(position);


        holder.imageView.setImageResource (Item.getImageResId());

        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(700);
        holder.itemView.startAnimation(animation);
        
        holder.itemView.setOnClickListener(v->{
            Intent intent = new Intent(context, FullScreen.class);
            intent.putExtra("imageResId", Item.getImageResId());
            intent.putExtra("musicResId", Item.getMusicResId());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
                });

    }
    @Override
    public int getItemCount() {return photoItemList.size();}

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
         ImageView imageView;


        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
             imageView = itemView.findViewById(R.id.photoImage);
        }
    }
}


