package com.example.justmanga.presentation.ui.activity

import android.os.Bundle
import android.view.Window
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.justmanga.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.refinery89.sharedcore.R89AdFactory
import com.refinery89.sharedcore.domain_layer.config.ConfigBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MainActivity : AppCompatActivity()
{
	
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		requestWindowFeature(Window.FEATURE_NO_TITLE)//will hide the title
		supportActionBar?.hide() //hide the title bar
		startKoin {
			modules(com.example.justmanga.domain.koin.modules)
			androidContext(applicationContext)
		}
		
		setContentView(R.layout.activity_main)
		
		setupWithNavController(
			findViewById<BottomNavigationView>(R.id.bottomNavigationView),
			Navigation.findNavController(this@MainActivity, R.id.nav_host_fragment)
		)
		
		val wrapper = findViewById<LinearLayout>(R.id.ad_container)
		val bannerConfigId = ConfigBuilder.BANNER_TEST_R89_CONFIG_ID
		R89AdFactory.createBanner(bannerConfigId, wrapper)
	}
}