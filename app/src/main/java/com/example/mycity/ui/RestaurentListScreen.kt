package com.example.mycity.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.data.UiState

@Composable
fun RestaurantListScreen(
    modifier: Modifier = Modifier,
    data: List<UiState>,
    onItemClick: (String, Int) -> Unit
) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp), contentPadding = PaddingValues(5.dp)
    ) {
        items(
            count = data.size,
            key = { data[it].name },
            itemContent = {
                CityItem(
                    dataItem = data[it],
                    fromHomeScreen = false,
                    onItemDetailClick = onItemClick,
                    color = Color(0xFF91F9B1)
                )
            }
        )
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RestaurantScreenPreview() {
//    RestaurantListScreen()
}