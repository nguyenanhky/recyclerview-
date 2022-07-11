package com.example.shareviewmodelbetweenfragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShareViewModel extends ViewModel {
    public final MutableLiveData<String> onValueReceive = new MutableLiveData<>();

    public void setUpdateValue(String item){
        onValueReceive.setValue(item);
    }

    public LiveData<String> getOnValueReceive() {
        return onValueReceive;
    }
}
