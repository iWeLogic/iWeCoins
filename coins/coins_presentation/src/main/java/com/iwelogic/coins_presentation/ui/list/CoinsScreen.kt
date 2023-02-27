package com.iwelogic.coins_presentation.ui.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CoinsScreen(
    viewModel: CoinsViewModel = hiltViewModel()
) {
    val uiState by viewModel.state.collectAsState()
    val scrollState = rememberLazyListState()

    when (val state = uiState) {
        is CoinsUiState.Loading -> {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is CoinsUiState.Error -> {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Error")
            }
        }
        is CoinsUiState.ScreenData -> {
            Box(contentAlignment = Alignment.Center) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    state = scrollState
                ) {
                    items(state.coins) { item ->
                        Text(modifier = Modifier.padding(5.dp), text = item.name ?: "")
                    }
                }
            }
        }
    }
}