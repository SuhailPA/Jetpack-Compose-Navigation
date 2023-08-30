package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.data.UiState

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    currentCity: UiState
) {
    Column(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = currentCity.image),
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        bottomStart = 45.dp,
                        bottomEnd = 45.dp
                    )
                )
                .weight(3f),
            contentDescription = currentCity.name,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextTitleComposable(
            name = currentCity.city,
            heading = "City",
            modifier = Modifier.weight(0.5f)
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextTitleComposable(
            name = currentCity.name,
            heading = "Restaurant",
            modifier = Modifier.weight(0.5f)
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextDescription(
            description =
            currentCity.description,
            modifier = Modifier.weight(2f)
        )

    }
}

@Composable
fun TextDescription(description: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .wrapContentHeight(align = Alignment.Bottom),
        shape = RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp)
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                text = "About",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun TextTitleComposable(name: String, heading: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = heading,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .weight(2f)
        )
        Text(
            text = ":",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .weight(1f)
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
        Text(
            text = name,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .weight(2f)
                .wrapContentWidth(align = Alignment.End)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDetailScreen() {
    DetailScreen(
        currentCity = UiState(
            name = "testName",
            city = "CityName"
        )
    )
}