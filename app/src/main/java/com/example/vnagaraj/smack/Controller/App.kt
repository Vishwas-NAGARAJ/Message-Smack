package com.example.vnagaraj.smack.Controller

import android.app.Application
import com.example.vnagaraj.smack.Utilities.SharedPrefs

/**
 * Created by vnagaraj on 10/10/2017.
 */
class App :Application() {

    companion object {
        lateinit var prefs: SharedPrefs
    }

    override fun onCreate() {
        prefs = SharedPrefs(applicationContext)
        super.onCreate()
    }
}