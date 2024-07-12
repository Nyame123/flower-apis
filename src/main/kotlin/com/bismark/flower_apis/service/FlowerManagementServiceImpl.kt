package com.bismark.flower_apis.service

import com.bismark.flower_apis.dao.FlowerDao
import com.bismark.flower_apis.domain.Flower
import com.bismark.flower_apis.dto.AddFlowerRequest
import com.bismark.flower_apis.dto.FlowerResponse
import com.bismark.flower_apis.dto.UpdateFlowerRequest
import com.bismark.flower_apis.transformer.FlowerTransformer
import com.bismark.flower_apis.transformer.toResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class FlowerManagementServiceImpl(
    private val flowerDao: FlowerDao,
    private val flowerTransformer: FlowerTransformer,
) : FlowerManagementService {

    override fun findById(id: Long): FlowerResponse? = findFlowerById(id)?.toResponse()

    override fun findAll(pageable: Pageable): Page<FlowerResponse> {
        return flowerDao.findAll(pageable).map(Flower::toResponse)
    }

    override fun save(addFlowerRequest: AddFlowerRequest): FlowerResponse {
        return saveOrUpdate(flowerTransformer.transform(addFlowerRequest))
    }

    override fun update(updateFlowerRequest: UpdateFlowerRequest): FlowerResponse {
        val flower = findFlowerById(updateFlowerRequest.id)
            ?: throw IllegalStateException("${updateFlowerRequest.id} not found!")
        return saveOrUpdate(
            flower.copy(
                name = updateFlowerRequest.name,
                price = updateFlowerRequest.price,
                description = updateFlowerRequest.description,
                url = updateFlowerRequest.url
            )
        )
    }

    override fun deleteById(id: Long) {
        flowerDao.deleteById(id)
    }

    private fun findFlowerById(id: Long): Flower? = flowerDao.findByIdOrNull(id)
    private fun saveOrUpdate(flower: Flower): FlowerResponse = flowerDao.save(flower).toResponse()
}