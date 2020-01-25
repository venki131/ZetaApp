package com.example.zetaapp

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

class ZetaApplication : Application(), KodeinAware{

    override val kodein = Kodein.lazy {
        import(androidXModule(this@ZetaApplication))

    }

    override fun onCreate() {
        super.onCreate()
    }
}