package com.bismark.flower_apis.dto

data class UpdateFlowerRequest(
    val id: Long,
    val name: String,
    val price: Double,
    val description: String,
    val url: String,
)
