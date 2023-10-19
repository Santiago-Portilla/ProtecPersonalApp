package com.portosdeveloper.protecpersonalapp.domain.repository

import com.portosdeveloper.protecpersonalapp.domain.module.User
import com.portosdeveloper.protecpersonalapp.domain.module.Response
import kotlinx.coroutines.flow.Flow
import java.io.File

interface UsersRepository {

    suspend fun create(user : User): Response<Boolean>
    suspend fun update(user: User):Response<Boolean>
    suspend fun saveImage(file : File): Response<String>
    fun getUserById(id: String): Flow<User>
    fun getUser(id: String): Flow<Response<User>>
    suspend fun updateSalaryWorkDay(user: User, newDate: String): Response<Boolean>


}