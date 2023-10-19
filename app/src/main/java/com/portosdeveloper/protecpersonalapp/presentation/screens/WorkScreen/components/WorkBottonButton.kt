package com.portosdeveloper.protecpersonalapp.presentation.screens.WorkScreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.portosdeveloper.protecpersonalapp.R
import com.portosdeveloper.protecpersonalapp.presentation.components.DefaultButtonImage
import com.portosdeveloper.protecpersonalapp.presentation.navigation.DetailsScreen

@Composable
fun WorkBottomButton(navController: NavHostController){

    DefaultButtonImage(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)
        ,
        text = "Necesitad ayuda en algo?",
        onClick = { navController.navigate(route = DetailsScreen.Help.route) },
        icon = painterResource(id = R.drawable.icon_help))

}