package com.example.girls4girls.data.model

data class UserRegistration(
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String
) : java.io.Serializable