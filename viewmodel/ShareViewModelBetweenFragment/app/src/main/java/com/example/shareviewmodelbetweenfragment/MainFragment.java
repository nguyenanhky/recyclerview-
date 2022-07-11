package com.example.shareviewmodelbetweenfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shareviewmodelbetweenfragment.databinding.FragmentMainBinding;


public class MainFragment extends Fragment {
    private FragmentMainBinding binding;
    private ShareViewModel shareViewModel;
    private static final String TAG = "MainFragment";

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpViewModel();
        String name = binding.enterName.getText().toString();
        if(name.isEmpty()){
            binding.enterName.setError("Please enter a name");
        }

    }

    private void setUpViewModel() {
        shareViewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);
        shareViewModel.setUpdateValue(binding.enterName.getText().toString());
//        shareViewModel.onValueReceive.observe(requireActivity(),item->{
//            shareViewModel.setUpdateValue(item);
//            Log.d(TAG, "setUpViewModel: ");
//        });
    }
}