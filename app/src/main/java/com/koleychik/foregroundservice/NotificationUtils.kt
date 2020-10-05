package com.koleychik.foregroundservice

import android.app.*
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class NotificationUtils {

    fun createNotification(context: Context, text : String) : Notification{
        val intent = Intent(context, MainActivity::class.java)
        intent.putExtra("hello", "Hello Intent")
        val pendingIntent = PendingIntent.getActivity(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        return NotificationCompat.Builder(context, Constants.CHANNEL_ID)
            .setContentTitle("FOREGROUND SERVICE")
            .setContentText(text)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
//            .setSound(alarmSound)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .build()
    }
}