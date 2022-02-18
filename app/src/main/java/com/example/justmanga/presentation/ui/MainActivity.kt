package com.example.justmanga.presentation.ui

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.justmanga.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.core.context.startKoin


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        supportActionBar?.hide(); //hide the title bar
        startKoin{
            modules(com.example.justmanga.domain.koin.modules)
        }

        setContentView(com.example.justmanga.R.layout.activity_main)

        NavigationUI.setupWithNavController(
            findViewById<BottomNavigationView>(R.id.bottomNavigationView),
            Navigation.findNavController(this@MainActivity, R.id.nav_host_fragment)
        )




    }
}