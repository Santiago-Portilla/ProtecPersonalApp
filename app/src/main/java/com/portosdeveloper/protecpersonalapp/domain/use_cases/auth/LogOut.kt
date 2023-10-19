package com.portosdeveloper.protecpersonalapp.domain.use_cases.auth

import com.portosdeveloper.protecpersonalapp.domain.repository.AuthRepository
import javax.inject.Inject

class LogOut @Inject constructor(private val repository: AuthRepository) {

    operator fun invoke() = repository.logOut()
}