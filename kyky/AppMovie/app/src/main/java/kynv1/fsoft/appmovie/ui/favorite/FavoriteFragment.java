package kynv1.fsoft.appmovie.ui.favorite;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kynv1.fsoft.appmovie.R;
import kynv1.fsoft.appmovie.databinding.FragmentFavoriteBinding;


public class FavoriteFragment extends Fragment {

    private FragmentFavoriteBinding binding;
    public FavoriteFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}