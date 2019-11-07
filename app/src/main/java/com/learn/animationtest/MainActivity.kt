package com.learn.animationtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fade = Fade()
        val decor = window!!.decorView
        fade.excludeTarget(android.R.id.navigationBarBackground, true)
        fade.excludeTarget(android.R.id.statusBarBackground, true)

        window?.enterTransition = fade
        window?.exitTransition = fade
    }
}
