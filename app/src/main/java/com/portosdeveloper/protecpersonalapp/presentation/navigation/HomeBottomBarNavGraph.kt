package com.portosdeveloper.protecpersonalapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.portosdeveloper.protecpersonalapp.presentation.screens.ProfileScreen.ProfileScreen
import com.portosdeveloper.protecpersonalapp.presentation.screens.WorkScreen.WorkScreen

@Composable
fun HomeBottomBarNavGraph(navController: NavHostController){

    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = HomeBottomBarScreen.Work.route
    ){
        composable(route = HomeBottomBarScreen.Work.route){
            WorkScreen(navController)
        }
        composable(route = HomeBottomBarScreen.Profile.route){
            ProfileScreen()

        }
        detailsNavGraph(navController)
    }

}

sealed class HomeBottomBarScreen(
    val route: String,
    val icon: ImageVector
){
    object Work: HomeBottomBarScreen(
        route = "work",
        icon = Icons.Default.List
    )
    object Profile: HomeBottomBarScreen(
        route = "profile",
        icon = Icons.Default.Person
    )
}