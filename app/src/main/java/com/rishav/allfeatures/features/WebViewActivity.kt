package com.rishav.allfeatures.features

import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rishav.allfeatures.R

class WebViewActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val myWebView = findViewById<WebView>(R.id.webView)
        webViewSetUp(myWebView)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun webViewSetUp(myWebView: WebView?) {
        myWebView?.webViewClient  = WebViewClient()

        myWebView?.apply {
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
//            loadUrl("https://movie-mania-liard.vercel.app")
            loadUrl("https://smvdu.ac.in")
        }

    }
}