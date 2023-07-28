package dev.android.hitanshu_dhawan_mccompose.ui.menu

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.android.hitanshu_dhawan_mccompose.model.Category
import dev.android.hitanshu_dhawan_mccompose.model.Menu
import dev.android.hitanshu_dhawan_mccompose.ui.components.Icon
import dev.android.hitanshu_dhawan_mccompose.ui.theme.Hitanshudhawan_McComposeTheme
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun MenuScreen(
    onBackClick: () -> Unit,
    onMenuItemClick: (Long) -> Unit
) {

    val viewModel: MenuViewModel = viewModel()

    val data by viewModel.data.observeAsState(Menu(emptyList(), emptyList()))

    val lazyListState = rememberLazyListState()

    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "McDonald's Menu") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Rounded.ArrowBack)
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier=Modifier.padding(paddingValues)) {

            Column {

                CategoryTabs(
                    categories = data.categories,
                    selectedCategory = lazyListState.firstVisibleItemIndex.getCategory(data),
                    onCategorySelected = { category ->
                        coroutineScope.launch { lazyListState.scrollToItem(category.getIndex(data)) }
                    }
                )
                Divider()

                LazyColumn(
                    state = lazyListState
                ) {
                    for (category in data.categories) {
                        item {
                            Text(
                                text = category.name,
                                style = MaterialTheme.typography.h4,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                        val menuItems = data.menuItems.filter { it.categoryId == category.id }
                        itemsIndexed(menuItems) { index, menuItem ->
                            MenuItem(
                                menuItem = menuItem,
                                onClick = { onMenuItemClick(menuItem.id) },
                                onIncrementMenuItemQuantity = { viewModel.incrementMenuItemQuantity(menuItem) },
                                onDecrementMenuItemQuantity = { viewModel.decrementMenuItemQuantity(menuItem) },
                            )
                            if (index != menuItems.lastIndex)
                                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.height(80.dp))
                    }
                }

            }

            AnimatedVisibility(
                visible = data.menuItems.any { it.quantity > 0 },
                enter = slideInVertically(
                    initialOffsetY = { it * 2 }
                ),
                exit = slideOutVertically(
                    targetOffsetY = { it * 2 }
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomCenter)
            ) {
                CartButton(
                    quantity = data.menuItems.sumOf { it.quantity },
                    price = data.menuItems.filter { it.quantity > 0 }.sumOf { it.price },
                    onClick = {}
                )
            }

        }
    }
}

private fun Int.getCategory(menu: Menu): Category {
    return menu.categories.last { it.getIndex(menu) <= this }
}

private fun Category.getIndex(menu: Menu): Int {
    var index = 0
    for (i in 0 until menu.categories.indexOf(this)) {
        index += 1
        index += menu.menuItems.filter { it.categoryId == menu.categories[i].id }.size
    }
    return index
}

@ExperimentalAnimationApi
@Preview("MenuScreen")
@Composable
private fun MenuScreenPreview() {
    Hitanshudhawan_McComposeTheme() {
        MenuScreen(
            onBackClick = {},
            onMenuItemClick = {}
        )
    }
}

@ExperimentalAnimationApi
@Preview("MenuScreen • Dark")
@Composable
private fun MenuScreenDarkPreview() {
    Hitanshudhawan_McComposeTheme() {
        MenuScreen(
            onBackClick = {},
            onMenuItemClick = {}
        )
    }
}