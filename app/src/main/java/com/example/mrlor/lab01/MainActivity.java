package com.example.mrlor.lab01;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    BindService bindService;
    boolean isBinded = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //uncomment if want to launch ServiceNotification
//        startService(new Intent(this, ServiceNotification.class));
        startService(new Intent(this, BindService.class));
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyListActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.buttonCounter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (isBinded) {
                    int counter = bindService.getCounter();
                    createToast(Integer.toString(counter));
//                    Intent intent = new Intent(getApplicationContext(), MyListActivity.class);
//                    startActivity(intent);
//                }
            }
        });

    }
    @Override
    protected void onStart()
    {
        super.onStart();

            Intent intent = new Intent(this, BindService.class);
            bindService(intent, bindConnection, Context.BIND_AUTO_CREATE);

    }

    @Override
    protected void onStop()
    {
        super.onStop();
        if(isBinded){
            unbindService(bindConnection);
            isBinded = false;
        }

        bindService.stopService(new Intent(this, BindService.class));
        createToast("Your bind service has stoped");
    }



    private ServiceConnection bindConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            BindService.LocalBinder binder = (BindService.LocalBinder) service;
            bindService = binder.getService();
            isBinded = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            isBinded = false;
        }
    };

    public void createToast(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
