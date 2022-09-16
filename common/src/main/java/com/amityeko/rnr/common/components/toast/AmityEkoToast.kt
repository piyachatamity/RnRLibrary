package com.amityeko.rnr.common.components.toast

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import com.amityeko.rnr.common.R

object AmityEkoToast {
    fun displayMessage(activity: Activity, @StringRes messageResId: Int, duration: Int) {
        val inflater: LayoutInflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout: View = inflater.inflate(R.layout.layout_custom_toast, activity.findViewById(R.id.toast_message_container))

        val text: TextView = layout.findViewById(R.id.toast_message_textview)
        text.text = activity.getText(messageResId)

        val toast = Toast(activity.applicationContext)
        toast.setGravity(Gravity.BOTTOM, 0, 200)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()

    }

    fun displayMessageStr(activity: Activity, messageStr: String, duration: Int) {
        val inflater: LayoutInflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout: View = inflater.inflate(R.layout.layout_custom_toast, activity.findViewById(R.id.toast_message_container))

        val text: TextView = layout.findViewById(R.id.toast_message_textview)
        text.text = messageStr

        val toast = Toast(activity.applicationContext)
        toast.setGravity(Gravity.BOTTOM, 0, 200)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()
    }
}