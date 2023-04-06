package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

import java.util.LinkedList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listOfWebsites = LinkedList<String>();
        val webView = WebView(this)
        val enterWebsitePlace = EditText(this)
        var counter = 0;

        webView.webViewClient = WebViewClient()
        val mainLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }


        val goButton = Button(this).apply {
            text = "Go"
            setOnClickListener {
                webView.loadUrl(enterWebsitePlace.text.toString())
                listOfWebsites.add(enterWebsitePlace.text.toString())
                counter++
            }
        }

        val backButton = Button(this).apply {
            text = "< Back"
            setOnClickListener {
                if (counter != 0){
                    counter--
                }
                enterWebsitePlace.setText(listOfWebsites[counter])
                webView.loadUrl(listOfWebsites[counter])

            }
        }

        val forwardButton = Button(this).apply {
            text = "Forward >"
            setOnClickListener {
                if (counter != listOfWebsites.size-1){
                    counter++
                }
                enterWebsitePlace.setText(listOfWebsites[counter])
                webView.loadUrl(listOfWebsites[counter])

            }
        }
        mainLayout.addView(enterWebsitePlace)
        mainLayout.addView(goButton)
        mainLayout.addView(backButton)
        mainLayout.addView(forwardButton)
        mainLayout.addView((webView))
        setContentView(mainLayout)
    }
}