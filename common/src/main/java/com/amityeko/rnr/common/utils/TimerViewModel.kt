package com.amityeko.rnr.common.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.os.SystemClock

import java.util.Timer
import java.util.TimerTask

class TimerViewModel : ViewModel() {

    private val ONE_SECOND = 100L

    private val mElapsedTime = MutableLiveData<Long>()

    private var mInitialTime: Long = 0
    private var timer: Timer? = null

    fun startTimer() {
        mInitialTime = SystemClock.elapsedRealtime()
        timer = Timer()

        timer!!.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val newValue: Long = (SystemClock.elapsedRealtime() - mInitialTime) / 1000
                mElapsedTime.postValue(newValue)
            }

        }, ONE_SECOND, ONE_SECOND)

    }

    fun getElapsedTime(): LiveData<Long> {
        return mElapsedTime
    }


    fun resetTimer() {
        timer?.cancel()
        mInitialTime = 0L
    }
}