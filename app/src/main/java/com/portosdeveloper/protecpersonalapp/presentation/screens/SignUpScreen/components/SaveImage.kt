package com.portosdeveloper.protecpersonalapp.presentation.screens.SignUpScreen.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.portosdeveloper.protecpersonalapp.domain.module.Response
import com.portosdeveloper.protecpersonalapp.presentation.components.DefaultProgressBar
import com.portosdeveloper.protecpersonalapp.presentation.screens.SignUpScreen.SignUpViewModel

@Composable
fun SaveImage(viewModel : SignUpViewModel = hiltViewModel()){

    when(val saveImageResponse = viewModel.saveImageResponse){
        Response.Loading -> {
            DefaultProgressBar()
        }
        is Response.Success -> {
            viewModel.onUpdate(saveImageResponse.data)

        }
        is Response.Failure ->{
            Toast.makeText(LocalContext.current, saveImageResponse.exception.message ?: "Error Desconosido", Toast.LENGTH_LONG).show()
        }
        else ->{}
    }

}