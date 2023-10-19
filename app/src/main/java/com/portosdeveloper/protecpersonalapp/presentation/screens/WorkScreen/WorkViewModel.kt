package com.portosdeveloper.protecpersonalapp.presentation.screens.WorkScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.portosdeveloper.protecpersonalapp.domain.module.Response
import com.portosdeveloper.protecpersonalapp.domain.module.User
import com.portosdeveloper.protecpersonalapp.domain.use_cases.auth.AuthUseCases
import com.portosdeveloper.protecpersonalapp.domain.use_cases.user.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val userUseCases: UserUseCases
) : ViewModel() {


    var getUserResponse by mutableStateOf<Response<User>?>(null)

    private val getCurrentUser = authUseCases.getCurrentUser()

    init{
        getUserById()
    }

    private fun getUserById() = viewModelScope.launch{
        userUseCases.getUser(getCurrentUser!!.uid).collect(){
            getUserResponse = it
        }
    }
}