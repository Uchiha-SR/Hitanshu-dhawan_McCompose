package dev.android.hitanshu_dhawan_mccompose.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Red200 = Color(0xFFEF9A9A)
val Red500 = Color(0xFFF44336)
val Red700 = Color(0xFFD32F2F)

val Amber200 = Color(0xFFFFE082)
val Amber500 = Color(0xFFFFC107)
val Amber700 = Color(0xFFFFA000)

val Gray100 = Color(0xFFF5F5F5)
val Gray900 = Color(0xFF212121)
class AppColors(
    primary: Color,
    text: Color,
    card: Color,
    background: Color,
    white: Color,
    black: Color,
    info: Color,
    warning: Color,
    success: Color,
    error: Color,
    isLight: Boolean
) {

    var primary by mutableStateOf(primary)
        private set

    var text by mutableStateOf(text)
        private set

    var card by mutableStateOf(card)
        private set

    var background by mutableStateOf(background)
        private set

    var white by mutableStateOf(white)
        private set

    var black by mutableStateOf(black)
        private set

    var information by mutableStateOf(info)
        private set

    var warning by mutableStateOf(warning)
        private set

    var success by mutableStateOf(success)
        private set

    var error by mutableStateOf(error)
        private set

    var isLight by mutableStateOf(isLight)
        private set

    fun copy(
        primary: Color = this.primary,
        text: Color = this.text,
        card: Color = this.card,
        background: Color = this.background,
        white: Color = this.white,
        black: Color = this.black,
        info: Color = this.information,
        warning: Color = this.warning,
        success: Color = this.success,
        error: Color = this.error,
        isLight: Boolean = this.isLight
    ): AppColors = AppColors(
        primary, text, card, background, white, black, info, warning, success, error, isLight
    )

    fun updateColorsFrom(other: AppColors) {
        primary = other.primary
        text = other.text
        card = other.card
        background = other.background
        white = other.white
        black = other.black
        information = other.information
        warning = other.warning
        success = other.success
        error = other.error
        isLight = other.isLight
    }
}

// light mode color themes
private val lightPrimaryColor = Color(0xFF000000)
private val lightTextColor = Color(0xFF000000)
private val lightCardColor = Color(0xFFFFFFFF)
private val lightBackgroundColor = Color(0xFFF6F9FF)

// neutral color
private val white = Color(0xFFFFFFFF)
private val black = Color(0xFF000000)

// state color for light theme
private val lightErrorColor = Color(0xFFEB5757)
private val lightWarningColor = Color(0xFFFFA93B)
private val lightSuccessColor = Color(0xFF6FCF97)
private val lightInformationColor = Color(0xFF006AF6)

// dark mode color themes
private val darkPrimaryColor = Color(0xFFFFFFFF)
private val darkTextColor = Color(0xFFFFFFFF)
private val darkCardColor = Color(0xFF0C1B3A)
private val darkBackgroundColor = Color(0xFF162544)

// state color for dark theme
private val darkErrorColor = Color(0xFFEB5757)
private val darkWarningColor = Color(0xFFFFA93B)
private val darkSuccessColor = Color(0xFF6FCF97)
private val darkInformationColor = Color(0xFF006AF6)

fun lightColors(
    primary: Color = lightPrimaryColor,
    text: Color = lightTextColor,
    card: Color = lightCardColor,
    background: Color = lightBackgroundColor,
    whiteLight: Color = white,
    blackLight: Color = black,
    info: Color = lightInformationColor,
    warning: Color = lightWarningColor,
    success: Color = lightSuccessColor,
    error: Color = lightErrorColor
): AppColors = AppColors(
    primary = primary,
    text = text,
    card = card,
    background = background,
    white = whiteLight,
    black = blackLight,
    info = info,
    warning = warning,
    success = success,
    error = error,
    isLight = true
)

fun darkColors(
    primaryDark: Color = darkPrimaryColor,
    textDark: Color = darkTextColor,
    cardDark: Color = darkCardColor,
    backgroundDark: Color = darkBackgroundColor,
    whiteDark: Color = black,
    blackDark: Color = whiteDark,
    infoDark: Color = darkInformationColor,
    warningDark: Color = darkWarningColor,
    successDark: Color = darkSuccessColor,
    errorDark: Color = darkErrorColor
): AppColors = AppColors(
    primary = primaryDark,
    text = textDark,
    card = cardDark,
    background = backgroundDark,
    white = whiteDark,
    black = blackDark,
    info = infoDark,
    warning = warningDark,
    success = successDark,
    error = errorDark,
    isLight = false
)

internal val LocalColors = staticCompositionLocalOf { lightColors() }