package com.bismark.flower_apis.transformer

import com.bismark.flower_apis.domain.Flower
import com.bismark.flower_apis.dto.FlowerResponse

fun Flower?.toResponse(): FlowerResponse =
    FlowerResponse(
        flowerName = this?.name ?: "",
        description = this?.description ?: "",
        url = this?.url ?: "",
        createdDate = this?.createdDate ?: 0L
    )