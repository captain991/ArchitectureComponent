package com.example.captain.arcitecturecomponent;

import android.app.Application;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

/**
 * Created by captain on 2018/9/26 上午12:32}.
 */
public class AndroidApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SQLiteStudioService.instance().start(this);
    }

}
