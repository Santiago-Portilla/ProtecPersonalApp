package com.portosdeveloper.protecpersonalapp.presentation.screens.ProfileScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.portosdeveloper.protecpersonalapp.domain.module.Response
import com.portosdeveloper.protecpersonalapp.domain.module.User
import com.portosdeveloper.protecpersonalapp.domain.use_cases.auth.AuthUseCases
import com.portosdeveloper.protecpersonalapp.domain.use_cases.user.UserUseCases
import com.portosdeveloper.protecpersonalapp.presentation.utils.ActualDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val userUseCases: UserUseCases
) : ViewModel() {

    var userData by mutableStateOf(User())
        private set

    var updateSalaryWorkDayResponse by mutableStateOf<Response<Boolean>?>(null)


    val getCurrentUser = authUseCases.getCurrentUser()

    val actualDate = ActualDate()

    init{
        onUpdateSalaryWorkDay()
        getUserById()
    }


    private fun updateSalaryWorkDay() =viewModelScope.launch {
        updateSalaryWorkDayResponse = Response.Loading
        val result = userUseCases.updateSalaryWorkDay(userData, actualDate.date)
        updateSalaryWorkDayResponse = result
    }

    private fun onUpdateSalaryWorkDay(){
        if(userData.actualDate != actualDate.date){
            updateSalaryWorkDay()
        }
    }

    private fun getUserById() = viewModelScope.launch{
        userUseCases.getUserById(getCurrentUser!!.uid).collect(){
            userData = it
        }
    }
    fun logOut(){
        authUseCases.logOut()
    }
}