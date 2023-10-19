package com.portosdeveloper.protecpersonalapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.portosdeveloper.protecpersonalapp.presentation.screens.home.HomeScreen

@Composable
fun RootNavGraph(navController: NavHostController){

    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ){

        authNavGraph(navController)
        composable(route = Graph.HOME){
            HomeScreen()
        }

    }
}