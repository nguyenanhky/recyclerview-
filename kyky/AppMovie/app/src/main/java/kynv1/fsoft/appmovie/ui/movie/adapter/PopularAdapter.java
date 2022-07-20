package kynv1.fsoft.appmovie.ui.movie.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kynv1.fsoft.appmovie.model.Popular;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {
    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PopularViewHolder extends RecyclerView.ViewHolder{

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
