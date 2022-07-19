package com.example.mock1;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mock1.model.Media;

import java.util.ArrayList;
import java.util.List;

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.MediaViewHolder> {
    private List<Media> list_media;
    private Clickitemmedia clickitemmedia;

    public void setData(List<Media> list_media) {
        this.list_media = list_media;
        notifyDataSetChanged();
    }

    public interface Clickitemmedia{
        void UpdateandDelete_media(Media media);
    }

    public MediaAdapter(Clickitemmedia clickitemmedia) {
        this.clickitemmedia = clickitemmedia;
    }

    @NonNull
    @Override
    public MediaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_media, parent, false);
        return new MediaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MediaViewHolder holder, int position) {
        Media media = list_media.get(position);
        if (media == null) {
            return;
        }
        holder.txt_medianame.setText(media.getMedianame());
        holder.txt_transportation.setText(media.getTransportation());
        holder.txt_price.setText(media.getPrice() + "");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickitemmedia.UpdateandDelete_media(media);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list_media.size();
    }

    public class MediaViewHolder extends RecyclerView.ViewHolder {
        private EditText txt_medianame;
        private EditText txt_transportation;
        private EditText txt_price;

        public MediaViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_medianame = itemView.findViewById(R.id.txt_medianame);
            txt_transportation = itemView.findViewById(R.id.txt_transportation);
            txt_price = itemView.findViewById(R.id.txt_price);
        }

    }
}
