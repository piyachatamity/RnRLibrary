package com.amityeko.rnr.common.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class BaseAppCombatActivity : AppCompatActivity() {

    fun addFragment(containerId: Int, fragment: Fragment, addToBackStack: String?) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(containerId, fragment)
        if (addToBackStack != null)
            transaction.addToBackStack(addToBackStack)
        transaction.commit()
        supportFragmentManager.executePendingTransactions()
        supportActionBar?.setDisplayHomeAsUpEnabled(supportFragmentManager.backStackEntryCount > 0)
    }
}