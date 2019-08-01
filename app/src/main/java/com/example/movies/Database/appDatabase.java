package com.example.movies.Database;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.movies.API.Movies;

@Database(entities = {Movies.MoviesBean.class},version = 1,exportSchema = false)
public abstract class appDatabase extends RoomDatabase {

    private static final String LOG_TAG=appDatabase.class.getSimpleName();
    private static final Object LOCK=new Object();
    private static final String Database_Name="Favourite Movies";
    private static appDatabase sInstance;


    public static appDatabase getInstance(Context context){
        if(sInstance==null){
            synchronized (LOCK){
                Log.d(LOG_TAG,"Creating New db instance");
                sInstance= Room.databaseBuilder(context.getApplicationContext(),
                        appDatabase.class,
                        appDatabase.Database_Name)
                        .build();
            }
        }
        Log.d(LOG_TAG,"getting db instance");
        return sInstance;
    }

    public abstract moviesDAO moviesDAO();
}
