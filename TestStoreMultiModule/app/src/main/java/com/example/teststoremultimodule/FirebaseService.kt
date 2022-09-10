package com.example.teststoremultimodule

import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavDeepLinkBuilder
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FirebaseService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        sendNotification(remoteMessage.data)
    }

    private fun sendNotification(message: MutableMap<String, String>) {
        val pendingIntent = NavDeepLinkBuilder(this)
            .setGraph(R.navigation.nav_graph_global)
            .setDestination(R.id.basketScreenFragment)
            .createPendingIntent()

        val channelId = getString(R.string.default_notification_channel_id)

        val notification = NotificationCompat.Builder(this, channelId)
            .setPriority(NotificationManagerCompat.IMPORTANCE_MAX)
            .setContentText(message["message"])
            .setContentTitle(message["title"])
            .setSmallIcon(R.drawable.icon)
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setContentIntent(pendingIntent)
            .build()

        NotificationManagerCompat.from(this).notify(0,notification)
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("Mart", "sendRegistrationTokenToServer($token)")
    }
}