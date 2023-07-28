package dev.android.hitanshu_dhawan_mccompose.ui.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.android.hitanshu_dhawan_mccompose.R
import dev.android.hitanshu_dhawan_mccompose.data.HomeRepository
import dev.android.hitanshu_dhawan_mccompose.ui.components.SearchBar
import dev.android.hitanshu_dhawan_mccompose.ui.components.SpotlightCard

import dev.android.hitanshu_dhawan_mccompose.ui.theme.Hitanshudhawan_McComposeTheme

@Composable
fun HomeScreen(
    onCategoryClick: () -> Unit,
    onMenuItemClick: () -> Unit,
) {

    val data = HomeRepository.getHomeData()
    var isDarkTheme by remember { mutableStateOf(true) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "McDonald's")
                },
               actions = {
                    IconButton(onClick = ) {
                        Icon( painter = when (isSystemInDarkTheme()) {
                            true -> painterResource(id = R.drawable.ic_bulb_off)
                            false -> painterResource(id = R.drawable.ic_bulb_on)
                        },
                            contentDescription = stringResource(R.string.text_bulb_turn_on),
                        )
                    }
                },



                )
        }
    )
             { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
                Text(
                    text = "Hi ${data.user.name}!",
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
                SearchBar(
                    text = "Find what you want...",
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
                LazyRow {
                    item { Spacer(modifier = Modifier.width(16.dp)) }
                    items(data.categories) { category ->
                        SpotlightCard(
                            title = category.name,
                            imageUrl = category.image,
                            onClick = onCategoryClick
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
                Text(
                    text = "Popular",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            items(data.popularMenuItems) { menuItem ->
                MenuItemCard(
                    menuItem = menuItem,
                    onClick = onMenuItemClick
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
                Text(
                    text = "Recommended",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            items(data.recommendedMenuItems) { menuItem ->
                MenuItemCard(
                    menuItem = menuItem,
                    onClick = onMenuItemClick
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }
        }
    }
}

@Preview("HomeScreen")
@Composable
private fun HomeScreenPreview() {
    Hitanshudhawan_McComposeTheme() {
        HomeScreen(
            onCategoryClick = {},
            onMenuItemClick = {},
        )
    }
}
/*
@Preview("HomeScreen • Dark")
@Composable
private fun HomeScreenDarkPreview() {
    Hitanshudhawan_McComposeTheme() {
        HomeScreen(
            onCategoryClick = {},
            onMenuItemClick = {},
        )
    }
}
*/
