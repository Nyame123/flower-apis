package com.bismark.flower_apis.transformer

import com.bismark.flower_apis.domain.Flower
import com.bismark.flower_apis.dto.AddFlowerRequest
import org.springframework.stereotype.Component

@Component
class FlowerTransformer: Transformer<AddFlowerRequest, Flower> {
    override fun transform(source: AddFlowerRequest): Flower {
        return Flower(name = source.name, price = source.price, description = source.description, url = source.url)
    }
}