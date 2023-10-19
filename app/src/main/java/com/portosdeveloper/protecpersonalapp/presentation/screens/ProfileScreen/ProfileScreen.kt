package com.portosdeveloper.protecpersonalapp.presentation.screens.ProfileScreen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.portosdeveloper.protecpersonalapp.presentation.screens.ProfileScreen.components.ProfileContent
import com.portosdeveloper.protecpersonalapp.presentation.screens.ProfileScreen.components.UpdateSalaryWorkDay

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(){

    Scaffold(
        content = { ProfileContent() }
    )

    UpdateSalaryWorkDay()

}