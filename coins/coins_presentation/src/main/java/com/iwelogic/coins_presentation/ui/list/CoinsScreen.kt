package com.iwelogic.coins_presentation.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.iwelogic.coins_presentation.models.Coin
import com.iwelogic.core.utils.orZero
import com.iwelogic.core.utils.twoDigitsAfterDot
import com.iwelogic.core_ui.Route

@Composable
fun CoinsScreen(
    title: String,
    navigate: (String) -> Unit,
    viewModel: CoinsViewModel = hiltViewModel()
) {
    val uiState by viewModel.state.collectAsState()
    val scrollState = rememberLazyListState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
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
            is CoinsState.Loading -> {
                Box(
                    Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is CoinsState.Error -> {
                Box(
                    Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Error")
                }
            }
            is CoinsState.ScreenData -> {
                Box(contentAlignment = Alignment.Center) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        state = scrollState
                    ) {
                        items(state.coins) { item ->
                            CoinItem(coin = item) {
                                navigate(Route.COIN_DETAILS)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CoinItem(coin: Coin, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 4.dp, 16.dp, 4.dp)
            .clickable(onClick = onClick)
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            model = coin.image,
            loading = {
                CircularProgressIndicator()
            },
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .weight(1.0f)
                .padding(16.dp, 0.dp, 0.dp, 0.dp),
        ) {
            Text(
                text = coin.name.orEmpty(),
                color = MaterialTheme.colors.onBackground
            )
            Text(
                color = if (coin.priceChange24h.orZero() < 0.0f) Color.Red else Color.Green,
                text = coin.priceChange24h.twoDigitsAfterDot()
            )
        }
        Text(
            text = "$${String.format("%.4f", coin.currentPrice.orZero())}",
            color = MaterialTheme.colors.onBackground
        )
    }
}