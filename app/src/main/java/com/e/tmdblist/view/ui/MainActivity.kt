package com.e.tmdblist.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.e.tmdblist.R


class MainActivity : AppCompatActivity() {

    val API_KEY = "633b0d5400a1437826672c9966199c0b"
    val CATEGORY = "popular"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}