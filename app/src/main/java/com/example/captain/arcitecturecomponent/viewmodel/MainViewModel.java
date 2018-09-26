package com.example.captain.arcitecturecomponent.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> name = new MutableLiveData<>();

    public MutableLiveData<String> getName() {
        return name;
    }

    public void setName(MutableLiveData<String> name) {
        this.name = name;
    }
}
