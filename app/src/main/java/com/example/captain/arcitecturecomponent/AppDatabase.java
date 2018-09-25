package com.example.captain.arcitecturecomponent;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.captain.arcitecturecomponent.dao.UserDAO;
import com.example.captain.arcitecturecomponent.entity.User;

/**
 * Created by captain on 2018/9/26 上午12:52}.
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    abstract UserDAO userDAO();
}
