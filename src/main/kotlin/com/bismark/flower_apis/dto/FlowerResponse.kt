package com.bismark.flower_apis.dto

data class FlowerResponse(
    val id: Long,
    val flowerName: String,
    val description: String,
    val url: String,
    val createdDate: Long,
)
