package com.example.globetrotterapp

import java.io.Serializable

class UserModel(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
) : Serializable