package com.asyikwae.safearly

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.asyikwae.safearly.auth.AuthActivity
import com.google.firebase.auth.FirebaseAuth

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        Handler(Looper.getMainLooper()).postDelayed({
            if (user!= null){
                val homeIntent = Intent(this, MainActivity::class.java)
                startActivity(homeIntent)
                finish()
            }else{
                val authIntent = Intent(this, AuthActivity::class.java)
                startActivity(authIntent)
                finish()
            }
        }, 2000)
    }
}