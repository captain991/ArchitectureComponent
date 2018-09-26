package com.example.captain.arcitecturecomponent.view;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.captain.arcitecturecomponent.R;
import com.example.captain.arcitecturecomponent.databinding.ActivityMainBinding;
import com.example.captain.arcitecturecomponent.room.AppDatabase;
import com.example.captain.arcitecturecomponent.room.entity.User;
import com.example.captain.arcitecturecomponent.viewmodel.MainViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    MainViewModel mainViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getName().setValue("Joe");
        mainViewModel.getName().observe(this, name -> {
            Log.d("captain", "LifeCycle state:" + getLifecycle().getCurrentState() + ",name:" + name);
            binding.setName(name);
        });
        Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onComplete();
        })
                .delay(5, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("captain", "onSubscribe");
                    }

                    @Override
                    public void onNext(Object o) {
                        mainViewModel.getName().setValue(o.toString());
                        Log.d("captain", "onNext:" + o.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("captain", "onError:" + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("captain", "onComplete");
                    }
                });

    }

}
