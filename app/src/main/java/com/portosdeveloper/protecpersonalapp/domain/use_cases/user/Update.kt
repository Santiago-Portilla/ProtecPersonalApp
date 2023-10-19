package com.portosdeveloper.protecpersonalapp.domain.use_cases.user

import com.portosdeveloper.protecpersonalapp.domain.module.User
import com.portosdeveloper.protecpersonalapp.domain.repository.UsersRepository
import javax.inject.Inject

class Update @Inject constructor(private val repository: UsersRepository){
    suspend operator fun invoke(user: User) = repository.update(user)
}