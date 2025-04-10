package com.example.justmanga.presentation

import android.app.Application
import com.refinery89.sharedcore.R89SDK

class Application: Application()
{
	override fun onCreate()
	{
		super.onCreate()
		R89SDK.setDebug() //This is for testing purposes, remove it on prod
		R89SDK.initialize(
			appContext = this,
			pubUUID = "TestRefinery89UUID",
			apiKey = "This-is-a-fake-key",
			singleLine = false,
			initializationEvents = null
		)
	}
}