package com.example.lab8kotlin

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder

class MyService : Service() {
    override fun onCreate() {
        super.onCreate()
        try {
            Thread {
                Thread.sleep(5000)  
                val intent = Intent(this@MyService, MainActivity2::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                this@MyService.startActivity(intent)
            }.start()
        }catch(e:InterruptedException){
            e.printStackTrace()
        }
    }

    override fun onStartCommand(intent: Intent, flags: Int, startid: Int): Int {
        super.onStartCommand(intent, flags, startid)
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }
}