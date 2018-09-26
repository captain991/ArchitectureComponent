package com.example.captain.arcitecturecomponent.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.captain.arcitecturecomponent.room.entity.User;

/**
 * Created by captain on 2018/9/26 上午12:13}.
 */
@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Query("SELECT * FROM user WHERE id = :id")
    com.example.captain.arcitecturecomponent.room.entity.User getUser(int id);
}
