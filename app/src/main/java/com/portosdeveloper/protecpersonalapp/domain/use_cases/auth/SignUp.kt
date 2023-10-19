package com.portosdeveloper.protecpersonalapp.domain.use_cases.auth

import com.portosdeveloper.protecpersonalapp.domain.module.User
import com.portosdeveloper.protecpersonalapp.domain.repository.AuthRepository
import javax.inject.Inject

class SignUp @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(user : User) = repository.signUp(user)
}