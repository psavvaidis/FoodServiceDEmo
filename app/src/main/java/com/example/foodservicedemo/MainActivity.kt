package com.example.foodservicedemo

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val face : Typeface = Typeface.createFromAsset(assets, "fonts/NABILA.TTF")
        txtSlogan.typeface = face

        btn_sign_up.setOnClickListener {  }
        btn_log_in.setOnClickListener {  }
    }
}
