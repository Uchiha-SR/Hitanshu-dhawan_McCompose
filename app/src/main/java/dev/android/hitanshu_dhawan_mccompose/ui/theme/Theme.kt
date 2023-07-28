package dev.android.hitanshu_dhawan_mccompose.ui.theme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val LightThemeColors = lightColors(
    primary = Red500,
    secondary = Amber500,
    background = Color.White,
    surface = Gray100
)

private val DarkThemeColors = darkColors(
    primary = Red700,
    secondary = Amber700,
    background = Color.Black,
    surface = Gray900
)

@Composable
fun Hitanshudhawan_McComposeTheme(
    lightTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (lightTheme) LightThemeColors else DarkThemeColors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}