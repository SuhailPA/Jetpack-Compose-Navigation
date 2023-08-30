package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.data.RestaurantDetails
import com.example.mycity.data.UiState


@Composable
fun CityItem(
    modifier: Modifier = Modifier,
    dataItem: UiState,
    fromHomeScreen: Boolean,
    color: Color,
    onItemClick: (String) -> Unit = {},
    onItemDetailClick: (String, Int) -> Unit = { s: String, i: Int -> }
) {
    val (image, text) = if (fromHomeScreen) Pair(dataItem.cityImage, dataItem.city)
    else Pair(dataItem.image, dataItem.name)
    Card(
        shape = RoundedCornerShape(topEnd = 20.dp, bottomStart = 20.dp),
        modifier = modifier.clickable {
            if (fromHomeScreen) onItemClick(dataItem.city)
            else onItemDetailClick(dataItem.name, dataItem.image)
        },
        colors = CardDefaults.cardColors(color)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = text,
                modifier = Modifier
                    .padding(5.dp)
                    .width(75.dp)
                    .height(80.dp)
                    .weight(1f)
                    .clip(MaterialTheme.shapes.large),
                contentScale = ContentScale.Crop
            )

            Text(
                text = text,
                modifier = Modifier
                    .padding(15.dp)
                    .weight(3f),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CityItemPreview() {
    CityItem(
        modifier = Modifier,
        dataItem =
        UiState(
            name = RestaurantDetails.nameList[0],
            city = RestaurantDetails.cityNames[0],
            image = R.drawable.pic1,
            cityImage = R.drawable.pic2
        ),
        fromHomeScreen = true,
        onItemClick = {},
        color = Color(0xffeef56e)
    )
}