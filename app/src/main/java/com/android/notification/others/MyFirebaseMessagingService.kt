package com.android.notification.others

import com.android.notification.utils.SharedPreferencesManager
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        SharedPreferencesManager.saveToken(applicationContext,token)
    }
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        if (remoteMessage.notification != null){
            com.android.notification.utils.NotificationManager.showNotification(
                applicationContext,
                remoteMessage.notification!!.title,
                remoteMessage.notification!!.body
               )
        }
    }

}