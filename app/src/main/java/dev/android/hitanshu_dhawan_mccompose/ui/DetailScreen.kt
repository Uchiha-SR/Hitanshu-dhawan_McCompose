package dev.android.hitanshu_dhawan_mccompose.ui
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.android.hitanshu_dhawan_mccompose.R
import dev.android.hitanshu_dhawan_mccompose.data.MenuRepository
import dev.android.hitanshu_dhawan_mccompose.ui.components.Icon
import dev.android.hitanshu_dhawan_mccompose.ui.components.NetworkImage


@Composable
fun DetailsScreen(
    menuItemId: Long,
    onBackClick: () -> Unit
) {

    val menuItem = MenuRepository.getMenuData().menuItems.find { it.id == menuItemId }!!

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = menuItem.name) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Rounded.ArrowBack)
                    }
                }
            )
        }
    ) {  contentPadding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(contentPadding)
        ) {

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.40f)
                        .background(MaterialTheme.colors.surface),
                    contentAlignment = Alignment.Center
                ) {
                    NetworkImage(
                        imageUrl = menuItem.image,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(32.dp),
                        previewPlaceholder = R.drawable.menu_item_double_quarter_pounder_with_cheese_meal
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(8.dp)) }

            item {
                Text(
                    text = menuItem.name,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            item { Spacer(modifier = Modifier.height(8.dp)) }

            item {
                Text(
                    text = "$" + "%.2f".format(menuItem.price),
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            item { Spacer(modifier = Modifier.height(8.dp)) }

            item {
                Text(
                    text = menuItem.description,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

        }
    }
}

