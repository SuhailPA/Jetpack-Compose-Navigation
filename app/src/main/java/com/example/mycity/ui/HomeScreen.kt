package com.example.mycity.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycity.data.UiState

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    data: List<UiState>,
    isFromHomeScreen: Boolean = false,
    onItemClick: (String) -> Unit
) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        contentPadding = PaddingValues(5.dp)
    ) {
        items(count = data.size,
            key = { data[it].name },
            itemContent = {
                CityItem(
                    dataItem = data[it],
                    fromHomeScreen = isFromHomeScreen,
                    onItemClick = onItemClick,
                    color = Color(0xFFF9F191)
                )
            })
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    val viewModel: CityViewModel = viewModel()
    LazyColumn() {
        items(viewModel.loadData()) {
            CityItem(
                dataItem = it, fromHomeScreen = true,
                onItemClick = {},
                color = Color(0xffeef56e)
            )
        }
    }
}

