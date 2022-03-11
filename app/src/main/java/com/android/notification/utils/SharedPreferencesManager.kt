package com.android.notification.utils

import android.content.Context
import com.android.notification.others.Constans
import com.android.notification.others.Constans.SHARED_PREFERNCE_NAME
import com.google.firebase.messaging.FirebaseMessagingService

object SharedPreferencesManager {

    fun saveToken(context: Context,token:String?){
        context.getSharedPreferences(SHARED_PREFERNCE_NAME, FirebaseMessagingService.MODE_PRIVATE).edit().putString(
            Constans.TOKEN, token).apply()
    }

    fun getToken(context: Context):String?{
        return context.getSharedPreferences(SHARED_PREFERNCE_NAME, FirebaseMessagingService.MODE_PRIVATE).getString(Constans.TOKEN, null)
    }
}