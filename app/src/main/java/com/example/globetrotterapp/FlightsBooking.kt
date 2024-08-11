package com.example.globetrotterapp

import java.io.Serializable

class FlightsBooking(
    val firstName: String,
    val email: String,
    val fromLocation: String,
    val toLocation: String,
    val seatNumber: String
) : Serializable
