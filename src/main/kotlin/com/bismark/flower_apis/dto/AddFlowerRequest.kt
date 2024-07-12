package com.bismark.flower_apis.dto

data class AddFlowerRequest(
    val name: String,
    val price: Double,
    val description: String,
    val url: String,
)
