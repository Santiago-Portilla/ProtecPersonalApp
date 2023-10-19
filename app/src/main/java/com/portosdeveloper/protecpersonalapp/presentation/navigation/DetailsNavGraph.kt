package com.portosdeveloper.protecpersonalapp.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.portosdeveloper.protecpersonalapp.presentation.screens.HelpScreen.HelpScreen


fun NavGraphBuilder.detailsNavGraph(navController: NavHostController){

    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Help.route
    ){
        composable(route = DetailsScreen.Help.route){
            HelpScreen()
        }

    }

}

sealed class DetailsScreen(val route : String){

    object Help: DetailsScreen("help")


}

