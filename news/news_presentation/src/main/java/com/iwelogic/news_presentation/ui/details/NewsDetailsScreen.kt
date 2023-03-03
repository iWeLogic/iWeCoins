package com.iwelogic.news_presentation.ui.details

import android.graphics.Bitmap
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.iwelogic.core_ui.Route

@Composable
fun NewsDetailsScreen(
    url: String?,
    navigate: (String) -> Unit,
    viewModel: NewsDetailsViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopAppBar(
            title = {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 52.dp),
                    textAlign = TextAlign.Center,
                    text = "News details",
                    style = MaterialTheme.typography.h3
                )
            },
            navigationIcon = {
                IconButton(onClick = { navigate(Route.NAVIGATION_UP) }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary
        )
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            var backEnabled by remember {
                mutableStateOf(false)
            }
            var webView: WebView? = null
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { context ->
                    WebView(context).apply {
                        layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                        webViewClient = object : WebViewClient() {
                            override fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?) {
                                backEnabled = view.canGoBack()
                            }
                        }
                        settings.javaScriptEnabled = true
                        Log.w("myLog", "loadUrl: ${url}")
                        loadUrl(url ?: "")
                        webView = this
                    }
                }, update = {
                    webView = it
                })

            BackHandler(enabled = backEnabled) {
                webView?.goBack()
            }
        }
    }
}