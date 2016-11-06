package com.example.mrlor.lab01;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class BindService extends Service {
    public BindService() {
    }
    private final IBinder mBinder = new LocalBinder();
    private final Random mGenerator = new Random();

    public class LocalBinder extends Binder {
        BindService getService() {
            // Return this instance of LocalService so clients can call public methods
            return BindService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }
}
