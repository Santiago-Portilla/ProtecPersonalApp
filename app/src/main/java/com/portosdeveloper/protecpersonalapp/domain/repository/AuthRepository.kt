package com.portosdeveloper.protecpersonalapp.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.portosdeveloper.protecpersonalapp.domain.module.Response
import com.portosdeveloper.protecpersonalapp.domain.module.User

interface AuthRepository {

    val currentUser: FirebaseUser?
    suspend fun login(email: String, password : String): Response<FirebaseUser>
    suspend fun signUp(user: User): Response<FirebaseUser>
    fun logOut()

}