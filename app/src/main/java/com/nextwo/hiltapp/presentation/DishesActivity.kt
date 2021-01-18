package com.nextwo.hiltapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nextwo.hiltapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DishesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.mainFrameContainer, DishesFragment()).commit()
    }
}