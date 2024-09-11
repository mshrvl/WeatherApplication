package com.example.weatherapplication

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.weatherapplication.screens.firstscreen.FirstScreen
import com.example.weatherapplication.screens.secondscreen.SecondScreen
import com.example.weatherapplication.screens.thirdscreen.SearchScreen

sealed class Screen(val route: String, val title: String) {
    object Current : Screen("current", "Текущая")
    object Weekly : Screen("weekly", "Недельная")
    object Search : Screen("search", "Поиск")
}


val items = listOf(
    Screen.Current,
    Screen.Weekly,
    Screen.Search
)


@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigation(modifier = Modifier.navigationBarsPadding()) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(Icons.Filled.DateRange, contentDescription = null) },
                        label = { Text(screen.title) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }


        },
        contentWindowInsets = WindowInsets(0,0,0,0)
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = Screen.Current.route
        ) {
            composable(Screen.Current.route) {
                FirstScreen()
            }
            composable(Screen.Weekly.route){
                SecondScreen()
            }
            composable(Screen.Search.route){
                SearchScreen()
            }
        }
    }
}


