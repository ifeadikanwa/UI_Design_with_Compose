package com.ifyezedev.uidesignwithcompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationBarItems(
    val route: String,
    val icon: ImageVector,
    val title: String
) {
    object Home: BottomNavigationBarItems("home", Icons.Default.Home, "Home")
    object Favorites: BottomNavigationBarItems("favorites", Icons.Default.Favorite, "Favorites")
    object Messages: BottomNavigationBarItems("messages", Icons.Default.Home, "Messages")
}
