package com.portosdeveloper.protecpersonalapp.domain.use_cases.user

data class UserUseCases (
    val create: Create,
    val getUserById: GetUserById,
    val update: Update,
    val saveImage: SaveImage,
    val getUser: GetUser,
    val updateSalaryWorkDay: UpdateSalaryWorkDay
)