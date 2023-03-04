package com.iwelogic.coins_presentation.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.iwelogic.core_ui.Route

@Composable
fun CoinDetailsScreen(
    navigate: (String) -> Unit,
    viewModel: CoinsDetailsViewModel = hiltViewModel()
) {

    val uiState by viewModel.state.collectAsState()

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
                    text = "Coin details",
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

        when (val state = uiState) {
            is CoinDetailsState.Loading -> {
                Box(
                    Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is CoinDetailsState.Error -> {
                Box(
                    Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Error")
                }
            }
            is CoinDetailsState.ScreenData -> {
                Box(contentAlignment = Alignment.Center) {
                    Chart(
                        Modifier
                            .aspectRatio(1f)
                            .fillMaxSize(),
                        state.coinDetails.history?.data?.map { ValueContainer(it.high ?: 0.0f, 1) } ?: ArrayList()
                    )
                }
            }
        }
    }
}