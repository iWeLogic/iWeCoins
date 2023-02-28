package com.iwelogic.news_presentation.ui.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.iwelogic.news_domain.models.News

@Composable
fun NewsScreen(
    title: String,
    viewModel: NewsViewModel = hiltViewModel()
) {
    val uiState by viewModel.state.collectAsState()
    val scrollState = rememberLazyListState()

    Column {
        TopAppBar(
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = title,
                    style = MaterialTheme.typography.h3
                )
            },
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary
        )
        when (val state = uiState) {
            is NewsState.Loading -> {
                Box(
                    Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is NewsState.Error -> {
                Box(
                    Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Error")
                }
            }
            is NewsState.NewsData -> {
                Box(contentAlignment = Alignment.Center) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        state = scrollState
                    ) {
                        items(state.news) { item ->
                            NewsItem(news = item)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NewsItem(news: News) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 4.dp, 16.dp, 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            model = news.imageurl,
            loading = {
                CircularProgressIndicator()
            },
            contentDescription = null
        )

        Text(
            modifier = Modifier
                .weight(1.0f)
                .padding(16.dp, 0.dp, 0.dp, 0.dp),
            text = news.title.orEmpty(),
            color = MaterialTheme.colors.onBackground
        )
    }
}
