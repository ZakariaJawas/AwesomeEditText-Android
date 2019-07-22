package com.edunology.zakedittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isEmpty
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnOK.setOnClickListener {
            if (cleanableEditText.text.isEmpty()) {
                cleanableEditText.setError(true)
            } else {
                cleanableEditText.setError(false)
            }
        }


    }
}
