package com.example.viewtypedemo;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {

    private  List<Actor> actorList;

    public ActorAdapter(List<Actor> actorList) {
        this.actorList = actorList;
    }


    @NonNull
    @Override
    public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case Actor.TYPE_GRID:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid,parent,false);
                break;
            case Actor.TYPE_LISt:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
                break;
            case Actor.TYPE_STAGGERED:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stagger,parent,false);
                break;
        }
        return new ActorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder holder, int position) {
        //set data
        Actor actor = actorList.get(position);
        if(actor==null){
            return;
        }
        Log.d("logger", "onBindViewHolder: ");

        holder.imgActor.setImageResource(actor.getResourceImage());
    }

    @Override
    public int getItemViewType(int position) {
        Actor actor = actorList.get(position);
        return actor.getTypeDisplay();
    }

    @Override
    public int getItemCount() {
        if (actorList != null) {
            return actorList.size();
        }
        return 0;
    }

    public  class ActorViewHolder extends RecyclerView.ViewHolder {
        private  ImageView imgActor;

        public ActorViewHolder(@NonNull View itemView) {
            super(itemView);
            imgActor = itemView.findViewById(R.id.imageMessi);

        }
    }
}
