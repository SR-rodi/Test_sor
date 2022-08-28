package com.example.teststoremultimodule

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.util.Log
import com.example.basket_screen.di.BasketScreenProvider
import com.example.di.DetailScreenProvider
import com.example.main_screen.di.MaineScreenProvider
import com.example.teststoremultimodule.di.AppComponent
import com.example.teststoremultimodule.di.DaggerAppComponent
import com.google.firebase.messaging.FirebaseMessaging


class StoreApp : Application() {

    private lateinit var appComponent: AppComponent



    override fun onCreate() {
        super.onCreate()

        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            Log.e("Mart", "Token -> ${task.result}")
        }

        appComponent = DaggerAppComponent
            .builder()
            .context(this)
            .build()

        createChanel()

        MaineScreenProvider.deps = appComponent
        BasketScreenProvider.deps = appComponent
        DetailScreenProvider.deps = appComponent
    }

    private fun createChanel() {
        val name ="high priority channel "
        val descriptionText = "This is description"
        val importance = NotificationManager.IMPORTANCE_HIGH

        val channel = NotificationChannel(
            getString(R.string.default_notification_channel_id),
            name,
            importance
        ).apply {
            description = descriptionText
            enableLights(true)
            lightColor = Color.GREEN

        }

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}



