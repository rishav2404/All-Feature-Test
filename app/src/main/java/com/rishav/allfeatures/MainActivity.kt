package com.rishav.allfeatures

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rishav.allfeatures.alertbox.AlertBoxActivity
import com.rishav.allfeatures.auth.SignUpActivity
import com.rishav.allfeatures.databinding.ActivityMainBinding
import com.rishav.allfeatures.dialogbox.DialogBoxActivity
import com.rishav.allfeatures.features.ImplicitIntentActivity
import com.rishav.allfeatures.features.MultiScreenActivity
import com.rishav.allfeatures.features.WebViewActivity
import com.rishav.allfeatures.photoframe.PhotoFrameActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val impIntentButton = findViewById<Button>(R.id.buttonImplicitIntent)
        val webViewButton = findViewById<Button>(R.id.buttonWebView)
        val multiScreenButton = findViewById<Button>(R.id.buttonMultiScreen)
        val signUpButton = findViewById<Button>(R.id.buttonSignInDB)


        impIntentButton.setOnClickListener {
            val intent = Intent(this, ImplicitIntentActivity::class.java)
            startActivity(intent)
        }

        webViewButton.setOnClickListener{
            val intent = Intent(this, WebViewActivity::class.java )
            startActivity(intent)
        }

        multiScreenButton.setOnClickListener{
            val intent = Intent(this, MultiScreenActivity::class.java )
            startActivity(intent)
        }

        signUpButton.setOnClickListener{
            val intent = Intent(this,SignUpActivity::class.java )
            startActivity(intent)
        }

        binding.btnDialogBox.setOnClickListener {
            val intent = Intent(this, DialogBoxActivity::class.java)
            startActivity(intent)
        }

        binding.btnAlertBox.setOnClickListener {
            val intent = Intent(this, AlertBoxActivity::class.java)
            startActivity(intent)
        }

        binding.btnPhotoFrame.setOnClickListener {
            val intent = Intent(this, PhotoFrameActivity::class.java)
            startActivity(intent)
        }
    }
}