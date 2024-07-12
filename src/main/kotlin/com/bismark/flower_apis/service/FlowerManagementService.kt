package com.bismark.flower_apis.service

import com.bismark.flower_apis.dto.AddFlowerRequest
import com.bismark.flower_apis.dto.FlowerResponse
import com.bismark.flower_apis.dto.UpdateFlowerRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface FlowerManagementService {

    fun findById(id: Long): FlowerResponse?
    fun findAll(pageable: Pageable): Page<FlowerResponse>
    fun save(addFlowerRequest: AddFlowerRequest): FlowerResponse
    fun update(updateFlowerRequest: UpdateFlowerRequest): FlowerResponse
    fun deleteById(id: Long)
}