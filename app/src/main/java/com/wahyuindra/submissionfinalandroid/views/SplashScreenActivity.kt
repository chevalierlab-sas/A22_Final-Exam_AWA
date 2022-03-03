package com.wahyuindra.submissionfinalandroid.views

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.wahyuindra.submissionfinalandroid.databinding.ActivitySplashScreenBinding
import com.wahyuindra.submissionfinalandroid.utils.SPLASH_SCREEN_TAG
import java.lang.Exception

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        object : Thread(){
            override fun run() {
                try {
                    sleep(1000)
                    startActivity(Intent(baseContext, MainActivity::class.java))
                    finish()
                } catch (e: Exception){
                    Log.d(SPLASH_SCREEN_TAG, e.message.toString())
                }
            }
        }.start()

        supportActionBar?.hide()
    }
}