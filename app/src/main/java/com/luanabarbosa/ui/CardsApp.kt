package com.luanabarbosa.ui

import android.app.Application
import com.luanabarbosa.details.di.detailsModule
import com.luanabarbosa.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CardsApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CardsApp)
            modules(listOf(detailsModule, homeModule))
        }
    }
}
