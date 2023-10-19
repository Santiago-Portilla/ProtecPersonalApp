package com.portosdeveloper.protecpersonalapp.presentation.screens.SignUpScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.portosdeveloper.protecpersonalapp.presentation.screens.SignUpScreen.components.SaveImage
import com.portosdeveloper.protecpersonalapp.presentation.screens.SignUpScreen.components.SignUp
import com.portosdeveloper.protecpersonalapp.presentation.screens.SignUpScreen.components.SignUpContent
import com.portosdeveloper.protecpersonalapp.presentation.screens.SignUpScreen.components.Update
import com.portosdeveloper.protecpersonalapp.presentation.ui.theme.Blue700
import com.portosdeveloper.protecpersonalapp.presentation.ui.theme.Brown700
import com.portosdeveloper.protecpersonalapp.presentation.ui.theme.Gray700

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignUpScreen(navController: NavHostController) {


    Scaffold(
        topBar = {
            Column() {
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 20.dp,
                    color = Blue700
                )
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 20.dp,
                    color = Brown700
                )
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 20.dp,
                    color = Gray700
                )
            }
        },
        content = {
            SignUpContent()
        }

    )
    SignUp()
    SaveImage()
    Update(navController = navController)
}