package com.portosdeveloper.protecpersonalapp.presentation.screens.ProfileScreen.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.portosdeveloper.protecpersonalapp.domain.module.Response
import com.portosdeveloper.protecpersonalapp.presentation.components.DefaultProgressBar
import com.portosdeveloper.protecpersonalapp.presentation.screens.ProfileScreen.ProfileViewModel

@Composable
fun UpdateSalaryWorkDay(viewModel: ProfileViewModel = hiltViewModel()){

    when(val updateSalaryWorkDay = viewModel.updateSalaryWorkDayResponse){
        Response.Loading ->{
            DefaultProgressBar()
        }
        is Response.Success ->{

        }
        is Response.Failure ->{
            Toast.makeText(LocalContext.current, updateSalaryWorkDay.exception.message  ?: "Error Desconocido", Toast.LENGTH_LONG).show()
        }
        else ->{

        }
    }

}