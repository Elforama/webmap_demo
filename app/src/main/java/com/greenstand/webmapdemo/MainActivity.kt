package com.greenstand.webmapdemo

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                WebPage(url = "https://alpha-dev.treetracker.org/")
            }
        }
    }
}

@Composable
fun WebPage(url: String) {
    val context = LocalContext.current
    AndroidView(factory = {
        WebView(context).apply {
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    })
}