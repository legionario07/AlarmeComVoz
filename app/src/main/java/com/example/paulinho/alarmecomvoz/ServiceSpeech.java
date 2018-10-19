package com.example.paulinho.alarmecomvoz;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by PauLinHo on 10/03/2018.
 */

public class ServiceSpeech extends Service {

    private int startId;
    public static boolean ativo = false;
    private Context context;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        startId = -1;
        if (ativo) {
            return;
        }
        ativo = true;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        this.startId = startId;



        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        stopSelf(startId);
        ativo = false;

    }


}
