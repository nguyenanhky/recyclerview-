package com.example.mock1.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mock1.DAO.MediaDao;
import com.example.mock1.model.Media;

@Database(entities = {Media.class},version = 1)

public abstract class Mediadatabase extends RoomDatabase {
    private static final String Databasename ="media_one.db";
    private static Mediadatabase instance;

    public  static synchronized Mediadatabase getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(), Mediadatabase.class,Databasename)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract MediaDao mediaDao();
}
