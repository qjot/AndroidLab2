package com.example.mrlor.lab01;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class ServiceNotification extends Service {
    public ServiceNotification() {}


    @Override
    public void onCreate()
    {
        Toast.makeText(this,"Service has beed started",Toast.LENGTH_LONG).show();
        new Timer().scheduleAtFixedRate( new TimerTask() {
            private Handler updateUI = new Handler(){
                @Override
                public void dispatchMessage(Message msg) {
                    super.dispatchMessage(msg);
                    createToast();
                }
            };
            public void run() {
                try {
                    updateUI.sendEmptyMessage(0);
                } catch (Exception e) {e.printStackTrace(); }
            }
        }, 0,10000);
    }
    public void createToast()
    {
        Toast.makeText(this,"Your service is still working",Toast.LENGTH_LONG).show();

    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
