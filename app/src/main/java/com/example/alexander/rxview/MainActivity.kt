package com.example.alexander.rxview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.alexander.rxview.mvp.MvpFragment
import com.example.alexander.rxview.mvvm.MvvmFragment
import com.example.alexander.rxview.rxmp.RxPmFragment

class MainActivity : AppCompatActivity(), Navigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            changeFragment(SwitchFragment.newInstance(), addToBackStack = false)
        }
    }

    override fun gotoMvp() = changeFragment(MvpFragment.newInstance())
    override fun gotoMvvm() = changeFragment(MvvmFragment.newInstance())
    override fun gotoRx() = changeFragment(RxPmFragment.newInstance())

    private fun changeFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .apply { if (addToBackStack) addToBackStack(null) }
            .commit()
    }
}
