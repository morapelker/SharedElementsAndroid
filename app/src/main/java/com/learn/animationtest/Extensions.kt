package com.learn.animationtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigator


fun Fragment.navigate(id: Int) {
    Navigation.findNavController(activity ?: return, R.id.nav_host_fragment).navigate(id)
}

fun Fragment.navigate(id: Int, extras: Navigator.Extras?) {
    Navigation.findNavController(activity ?: return, R.id.nav_host_fragment)
        .navigate(id, null, null, extras)
}