package com.example.rnruikit

import android.app.Application
import timber.log.Timber

class ApplicationApp : Application(){
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        Timber.d("Hello timber message")
//        RnR.rerg

        // api key
        //Dev: ed88a84dfc7ee546e233bc1ae4ddc459ff049daba0cb2e71fe2e67fa1d3230731405bd950882605d
        //DEV: ffe5bd3b1cb3128fc9e185f0057c33856f5dc665d4a71ae1fc653d3fe69501344ea3a82dc84344cf
        //Demo: fe8cb695519d7b42eae246e906ab5101187d7aaa021af8a6fa25ec888f48158394c858aba6cac0c3

//        val apiKey = "fe8cb695519d7b42eae246e906ab5101187d7aaa021af8a6fa25ec888f48158394c858aba6cac0c3"
//        RewardAndRecognition.registerDevice(this, apiKey, "132", "aaa")
//            .onErrorReturn {
//                Timber.e("Register device error: ${it.message}")
//                Toast.makeText(this, "Register device error: ${it.message}", Toast.LENGTH_SHORT).show()
//                false
//            }
//            .doOnNext {
//                Timber.d("register finish with result: $it")
//            }
//            .subscribe()

    }
}