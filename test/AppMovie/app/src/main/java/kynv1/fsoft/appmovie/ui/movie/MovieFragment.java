package kynv1.fsoft.appmovie.ui.movie;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import kynv1.fsoft.appmovie.R;
import kynv1.fsoft.appmovie.databinding.FragmentMovieBinding;
import kynv1.fsoft.appmovie.model.Result;
import kynv1.fsoft.appmovie.ui.movie.adapter.PopularAdapter;
import kynv1.fsoft.appmovie.utls.Constance;


public class MovieFragment extends Fragment {
    private FragmentMovieBinding binding;
    private List<Result> results;
    private PopularAdapter popularAdapter;
    private LinearLayoutManager linearLayoutManager;
    private PopularViewModel popularViewModel;
    private static final String TAG = "MovieFragment";
    public MovieFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showPopularMovies();
        addControls();
    }

    private void addControls() {
        popularAdapter =new PopularAdapter();
        linearLayoutManager = new LinearLayoutManager(getContext());
        binding.rcvMovie.setLayoutManager(linearLayoutManager);
        binding.rcvMovie.setAdapter(popularAdapter);
        popularAdapter.setData(results);
    }


    private void showPopularMovies() {
        results = new ArrayList<>();
        popularViewModel = new ViewModelProvider(requireActivity()).get(PopularViewModel.class);

        popularViewModel.getPopularMovies(Constance.KEY_MOVIE,1).observe(requireActivity(),popular -> {
            if(popular!=null){
                Log.d(TAG, "showPopularMovies: ");
                results.addAll(popular.getResults());
                popularAdapter.setData(results);
                Log.d(TAG, "showPopularMovies: "+popular.getResults().get(0).getBackdrop_path());

            }
        });
    }
}