package kynv1.fsoft.appmovie.ui.movie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kynv1.fsoft.appmovie.R;
import kynv1.fsoft.appmovie.databinding.FragmentMovieBinding;


public class MovieFragment extends Fragment {
    private FragmentMovieBinding binding;
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
}