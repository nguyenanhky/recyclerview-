package com.example.shareviewmodelbetweenfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shareviewmodelbetweenfragment.databinding.FragmentDestinationBinding;


public class DestinationFragment extends Fragment {
    private FragmentDestinationBinding binding;
    private ShareViewModel shareViewModel;
    private static final String TAG = "DestinationFragment";
    public DestinationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDestinationBinding.inflate(inflater, container, false);
        shareViewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shareViewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);

        Log.d(TAG, "onViewCreated: ");
        shareViewModel.onValueReceive.observe(requireActivity(),item->{
            Log.d(TAG, "onViewCreated: "+item);
        });
    }

}