package com.portosdeveloper.protecpersonalapp.presentation.screens.WorkScreen.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.portosdeveloper.protecpersonalapp.domain.module.Response
import com.portosdeveloper.protecpersonalapp.presentation.components.DefaultProgressBar
import com.portosdeveloper.protecpersonalapp.presentation.screens.LoginScreen.LoginViewModel
import com.portosdeveloper.protecpersonalapp.presentation.screens.WorkScreen.WorkViewModel

@Composable
fun GetUser(viewModel: WorkViewModel = hiltViewModel()){
    when(val getUserResponse = viewModel.getUserResponse){
        Response.Loading ->{
            DefaultProgressBar()
        }
        is Response.Success ->{
            WorkContent(user = getUserResponse.data)
        }
        is Response.Failure ->{
            Toast.makeText(LocalContext.current, getUserResponse.exception.message ?: "Error Desconosido", Toast.LENGTH_LONG).show()
        }
        else ->{}
    }
}