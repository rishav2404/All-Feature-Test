package com.rishav.allfeatures.auth

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rishav.allfeatures.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Data passed from LoginActivity(indirectly from firebase DB)
        val name = intent.getStringExtra(LoginActivity.KEY2)
        val mail = intent.getStringExtra(LoginActivity.KEY1)
        val userId = intent.getStringExtra(LoginActivity.KEY3)

        val welcomeText = findViewById<TextView>(R.id.tVWelcome)
        val mailText = findViewById<TextView>(R.id.tvMail)
        val uniqueIdText = findViewById<TextView>(R.id.tvUniqueId)

        // Set the text of the TextView according to data passed from LoginActivity
        welcomeText.text = "Welcome $name"
        mailText.text = "Email : $mail"
        uniqueIdText.text = "Unique Id : $userId"

    }
}