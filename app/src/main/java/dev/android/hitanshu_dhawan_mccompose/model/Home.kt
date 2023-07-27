package dev.android.hitanshu_dhawan_mccompose.model

data class Home(
    val user: User,
    val categories: List<Category>,
    val popularMenuItems: List<MenuItem>,
    val recommendedMenuItems: List<MenuItem>
)
