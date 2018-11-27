package com.yanuwar.rawunay.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yanuwar.rawunay.R
import com.yanuwar.rawunay.model.Board

class MainApp : AppCompatActivity() {

    val board = Board()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_app)
    }
}
