package com.example.mrlor.lab01;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

public class ServiceNotification extends Service {
    public ServiceNotification() {
    }
    @Override
    public void onCreate()
    {
        Toast.makeText(this,"Service has beed started",Toast.LENGTH_LONG).show();
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
