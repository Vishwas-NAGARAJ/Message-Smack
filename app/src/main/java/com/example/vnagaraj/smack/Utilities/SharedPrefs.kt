package com.example.vnagaraj.smack.Utilities

import android.content.Context
import android.content.SharedPreferences
import com.android.volley.toolbox.Volley

/**
 * Created by vnagaraj on 10/10/2017.
 */
class SharedPrefs(context: Context) {
    val PREFS_FILENAME = "prefs"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME , 0)

    val IS_LOGGED_IN = "isLoggedIn"
    val USER_EMAIL = "userEmail"
    val AUTH_TOKEN = "authToken"

    var isLoggedIn: Boolean
        get() = prefs.getBoolean(IS_LOGGED_IN , false)
        set(value) = prefs.edit().putBoolean(IS_LOGGED_IN , value).apply()

    var userEmail: String
        get() = prefs.getString(USER_EMAIL , "")
        set(value) = prefs.edit().putString(USER_EMAIL , value).apply()

    var authToken: String
        get() = prefs.getString(AUTH_TOKEN , "")
        set(value) = prefs.edit().putString(AUTH_TOKEN , value).apply()

    val requestQueue = Volley.newRequestQueue(context)
}