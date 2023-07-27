package dev.android.hitanshu_dhawan_mccompose.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import coil.compose.AsyncImage
import dev.android.hitanshu_dhawan_mccompose.R

@Composable
fun NetworkImage (
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    fadeIn: Boolean = true,
    @DrawableRes previewPlaceholder: Int = 0
){

//    Box(modifier.height(150.dp).width(150.dp)) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = previewPlaceholder),
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
 //   }
}
