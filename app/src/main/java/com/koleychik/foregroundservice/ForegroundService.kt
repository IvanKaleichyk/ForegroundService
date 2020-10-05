package com.koleychik.foregroundservice

import android.app.Service
import android.content.Intent
import android.os.IBinder

class ForegroundServer : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        startForeground(
            1,
            intent!!.extras!!.getString(Constants.TEXT)?.let {text ->
                NotificationUtils().createNotification(this,
                    text
                )
            }
        )
        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}