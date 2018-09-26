package com.example.captain.arcitecturecomponent;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.captain.arcitecturecomponent.room.AppDatabase;
import com.example.captain.arcitecturecomponent.room.entity.User;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

/**
 * Created by captain on 2018/9/26 上午12:32}.
 */
public class AndroidApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SQLiteStudioService.instance().start(this);
        initDb();
    }

    public void initDb() {
        AppDatabase appDatabase = Room.databaseBuilder(this, AppDatabase.class, "ArchitectureComponent").build();
        Observable.just(new User(100, "Joe", 20), new User(101, "Max", 18))
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        appDatabase.userDAO().insertUser(user);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
