package com.asyikwae.safearly.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.asyikwae.safearly.MainActivity
import com.asyikwae.safearly.R

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        supportActionBar?.hide()

        startActivity(Intent(this, MainActivity::class.java))
    }
}