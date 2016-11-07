package com.example.mrlor.lab01;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class BindService extends Service {
    public BindService() {
    }
    private final IBinder mBinder = new LocalBinder();
    private int counter = 0;

    public class LocalBinder extends Binder {
        BindService getService() {
            // Return this instance of LocalService so clients can call public methods
            return BindService.this;
        }
    }
    @Override
    public void onCreate()
    {
        createToast("Bound service has beed started");
        new Timer().scheduleAtFixedRate(new TimerTask() {
            private Handler updateUI = new Handler(){
                @Override
                public void dispatchMessage(Message msg) {
                    super.dispatchMessage(msg);
                    createToast("Your bound service is still working");
                    counter++;
                }
            };
            public void run() {
                try {
                    updateUI.sendEmptyMessage(0);
                } catch (Exception e) {e.printStackTrace(); }
            }
        }, 0,10000);
    }
    public void createToast(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int getCounter() {
        return counter;
    }
}
