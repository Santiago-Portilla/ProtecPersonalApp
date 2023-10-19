package com.portosdeveloper.protecpersonalapp.presentation.screens.WorkScreen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.portosdeveloper.protecpersonalapp.presentation.screens.WorkScreen.components.GetUser
import com.portosdeveloper.protecpersonalapp.presentation.screens.WorkScreen.components.WorkBottomButton
import com.portosdeveloper.protecpersonalapp.presentation.screens.WorkScreen.components.WorkContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WorkScreen(navController: NavHostController){

    Scaffold(
        content = {
            GetUser()
        },
        bottomBar = {
            WorkBottomButton(navController = navController)
        }
    )
}