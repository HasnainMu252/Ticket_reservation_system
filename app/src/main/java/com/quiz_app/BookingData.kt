package com.quiz_app

import java.io.Serializable

data class BookingData(
    val username:String,
    val seats:String
) : Serializable
