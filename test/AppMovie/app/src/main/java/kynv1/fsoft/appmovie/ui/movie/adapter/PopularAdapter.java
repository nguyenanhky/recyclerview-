package kynv1.fsoft.appmovie.ui.movie.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import kynv1.fsoft.appmovie.R;
import kynv1.fsoft.appmovie.model.Popular;
import kynv1.fsoft.appmovie.model.Result;
import kynv1.fsoft.appmovie.utls.Constance;

public class PopularAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Result> results = new ArrayList<>();
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    private static final String TAG = "PopularAdapter";

    public void setData(List<Result>results){
        this.results = results;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemmovie, parent, false);
            return new PopularViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof PopularViewHolder) {

            populateItemRows((PopularViewHolder) viewHolder, position);
        } else if (viewHolder instanceof LoadingViewHolder) {
            showLoadingView((LoadingViewHolder) viewHolder, position);
        }
    }

    private void populateItemRows(PopularViewHolder viewHolder, int position) {
        Result result = results.get(position);
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+ result.getBackdrop_path()).into(viewHolder.imaAvatar);
        viewHolder.txtOverView.setText(result.getOverview());
        viewHolder.txtReleaseDate.setText(result.getRelease_date());
        viewHolder.txtTitleMovie.setText(result.getOriginal_title());
        viewHolder.txtVoteAverage.setText(result.getVote_average()+"/10");
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PopularViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTitleMovie,txtReleaseDate,txtVoteAverage,txtOverView;
        private ImageView imaAvatar,imgStart;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitleMovie = itemView.findViewById(R.id.txtTitleMovie);
            txtReleaseDate = itemView.findViewById(R.id.txtReleaseDate);
            txtVoteAverage  = itemView.findViewById(R.id.txtVoteAverage);
            txtOverView = itemView.findViewById(R.id.txtOverView);

            imaAvatar = itemView.findViewById(R.id.imaAvatar);
            imgStart = itemView.findViewById(R.id.imgStart);
        }
    }

    private class LoadingViewHolder extends RecyclerView.ViewHolder {

        ProgressBar progressBar;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }

    private void showLoadingView(LoadingViewHolder viewHolder, int position) {
        //ProgressBar would be displayed

    }
}
