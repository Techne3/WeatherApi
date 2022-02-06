package com.example.weatherapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapi.view.SearchFragment


const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container_view, SearchFragment())
                .commit()


        }
    }
}