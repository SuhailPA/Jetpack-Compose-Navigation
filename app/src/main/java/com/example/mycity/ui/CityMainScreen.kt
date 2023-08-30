package com.example.mycity.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.Utils.CityScreenNames

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityMainScreen(
    viewModel: CityViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()

    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = CityScreenNames.valueOf(
        backStackEntry?.destination?.route ?: CityScreenNames.Home.name
    )

    Scaffold(topBar = {
        CityAppBar(
            currentScreen = currentScreen,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() }
        )
    }) {
        NavHost(
            navController = navController,
            startDestination = CityScreenNames.Home.name,
            modifier = Modifier.padding(it)
        ) {
            composable(route = CityScreenNames.Home.name) {
                HomeScreen(
                    data = viewModel.loadData(),
                    isFromHomeScreen = true,
                    onItemClick = { cityName ->
                        navController.navigate(route = CityScreenNames.Restaurant.name)
                        viewModel.updateCityName(cityName)
                    }
                )
            }

            composable(route = CityScreenNames.Restaurant.name) {
                RestaurantListScreen(
                    data = viewModel.loadData(),
                    onItemClick = { name: String, image: Int ->
                        navController.navigate(route = CityScreenNames.Detail.name)
                        viewModel.updateRestaurantName(name, image)
                    })
            }

            composable(route = CityScreenNames.Detail.name) {
                DetailScreen(currentCity = uiState)
            }
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityAppBar(
    currentScreen: CityScreenNames,
    modifier: Modifier = Modifier,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit
) {
    TopAppBar(title = { Text(text = currentScreen.title) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = when (currentScreen) {
                CityScreenNames.Home -> Color(0xFFF9F191)
                CityScreenNames.Restaurant -> Color(0xFF91F9B1)
                CityScreenNames.Detail -> Color.Transparent
            }
        ),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = { navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back Button"
                    )
                }
            }
        })
}

@Preview
@Composable
fun PreviewCityApp() {
    CityMainScreen()
}
