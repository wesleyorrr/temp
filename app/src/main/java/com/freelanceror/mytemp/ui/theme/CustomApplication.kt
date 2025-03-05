package com.freelanceror.mytemp.ui.theme

import android.app.Application

@HiltAndroidApp
class CustomApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}