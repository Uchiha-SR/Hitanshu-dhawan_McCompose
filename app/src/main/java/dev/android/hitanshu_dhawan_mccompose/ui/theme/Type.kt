package dev.android.hitanshu_dhawan_mccompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.android.hitanshu_dhawan_mccompose.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

/*
val sailec = FontFamily(
    Font(R.font.sailec_regular),
    Font(R.font.sailec_medium, FontWeight.SemiBold),
    Font(R.font.sailec_bold, FontWeight.Bold)
)
*/
data class AppTypography(

    val bigTitle: TextStyle = TextStyle(

        fontWeight = FontWeight.Bold,
        fontSize = 48.sp
    ),

    val h1: TextStyle = TextStyle(

        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    ),

    val h2: TextStyle = TextStyle(

        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),

    val subtitle: TextStyle = TextStyle(

        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),

    val body: TextStyle = TextStyle(

        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp
    ),

    val button: TextStyle = TextStyle(

        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),

    val caption: TextStyle = TextStyle(

        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),

    val overline: TextStyle = TextStyle(

        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
        letterSpacing = 1.25.sp
    )

)

internal val LocalTypography = staticCompositionLocalOf { AppTypography() }