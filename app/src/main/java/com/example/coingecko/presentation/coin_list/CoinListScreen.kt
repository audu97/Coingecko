package com.example.coingecko.presentation.coin_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coingecko.presentation.components.CoinListItem

@Composable
fun CoinListScreen (viewModel: CoinListViewModel = hiltViewModel()) {

    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize(), ) {
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(state.coins){ coin ->
                CoinListItem(coin = coin)

            }
        }

        if (state.error.isNotBlank()){
            Text(
                text =state.error,
                color = colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)

            )
        }
        if (state.isLoading){
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }
    }
}