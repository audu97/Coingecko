package com.example.coingecko.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coingecko.R
import com.example.coingecko.domain.model.Coin

@Composable
fun CoinListItem(coin: Coin,) {

    var expanded by remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp,
        backgroundColor =  colorResource(id = R.color.teal_700)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    text = coin.name,
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis,
                    color = colorResource(id = R.color.white)
                )

                AnimatedVisibility(visible = expanded) {
                    Column(modifier = Modifier.padding(4.dp)) {
                        Text(
                            text = "Id: ${coin.id}", style = MaterialTheme.typography.caption,
                            color = colorResource(id = R.color.white)
                        )
                        Text(
                            text = "Symbol: ${coin.symbol}", style = MaterialTheme.typography.caption,
                            color = colorResource(id = R.color.white)
                        )
                    }

                }
                Icon(imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else
                    Icons.Filled.KeyboardArrowDown,
                    modifier = Modifier
                        .size(25.dp)
                        .clickable { expanded = !expanded },
                    tint = Color.DarkGray,
                    contentDescription = "Down Arrow" )

            }

        }

    }
}

@Preview
@Composable
fun CoinListItemPrev() {

}