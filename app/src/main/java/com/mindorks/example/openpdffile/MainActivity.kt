package com.mindorks.example.openpdffile

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var doubleClickToExitApp = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpOnClickListener()
    }

    private fun setUpOnClickListener() {
        buttonWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
        buttonAssets.setOnClickListener {
            val intent = Intent(this, PdfViewActivity::class.java)
            intent.putExtra("ViewType", "assets")
            startActivity(intent)
        }
        buttonStorage.setOnClickListener {
            val intent = Intent(this, PdfViewActivity::class.java)
            intent.putExtra("ViewType", "storage")
            startActivity(intent)
        }
        buttonInternet.setOnClickListener {
            val intent = Intent(this, PdfViewActivity::class.java)
            intent.putExtra("ViewType", "internet")
            startActivity(intent)
        }
    }

    override fun onBackPressed() {

        if(doubleClickToExitApp){
            super.onBackPressed()
            return
        }
        doubleClickToExitApp = true
        Toast.makeText(this,"Please click again to exit!",Toast.LENGTH_LONG).show()

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            doubleClickToExitApp = false
        },2000)

    }

}
