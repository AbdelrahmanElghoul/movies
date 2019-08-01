package com.example.movies.Database;


import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class appExecuters {

    private static final Object LOCK=new Object();
    private static appExecuters sInstance;
    private final Executor diskIO;
    private final Executor mainThread;
    private final Executor networkIO;

    private appExecuters(Executor diskIO, Executor mainThread, Executor networkIO)  {
        this.diskIO = diskIO;
        this.mainThread = mainThread;
        this.networkIO = networkIO;
    }

    public static appExecuters getInstance(){
        if(sInstance==null){
            synchronized (LOCK){
                sInstance=new appExecuters(Executors.newSingleThreadExecutor(),
                        Executors.newFixedThreadPool(3),
                        new MainThreadExecutor());
            }
        }
        return sInstance;
    }

    public Executor diskIO(){return diskIO;}

    public Executor mainThread(){ return  mainThread;}

    public Executor networkIO(){ return networkIO;}

    private static class MainThreadExecutor implements Executor{

        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());
        @Override
        public void execute(Runnable command) {
            mainThreadHandler.post(command);
        }
    }

}
