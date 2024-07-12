package com.bismark.flower_apis.controller

import com.bismark.flower_apis.controller.FlowerController.Companion.BASE_FLOWER_URL
import com.bismark.flower_apis.dto.AddFlowerRequest
import com.bismark.flower_apis.dto.FlowerResponse
import com.bismark.flower_apis.dto.UpdateFlowerRequest
import com.bismark.flower_apis.service.FlowerManagementService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_FLOWER_URL])
class FlowerController(private val flowerManagementService: FlowerManagementService) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<FlowerResponse> =
        ResponseEntity.status(HttpStatus.OK).body(flowerManagementService.findById(id))

    @GetMapping
    fun findAll(pageable: Pageable): ResponseEntity<Page<FlowerResponse>> =
        ResponseEntity.status(HttpStatus.OK).body(flowerManagementService.findAll(pageable))

    @PostMapping
    fun save(@RequestBody addFlowerRequest: AddFlowerRequest): ResponseEntity<FlowerResponse> {
        val flower = flowerManagementService.save(addFlowerRequest)
        return ResponseEntity.created(URI.create(BASE_FLOWER_URL.plus("/${flower.id}"))).body(flower)
    }

    @PutMapping
    fun update(updateFlowerRequest: UpdateFlowerRequest): ResponseEntity<FlowerResponse> {
        return ResponseEntity.ok(flowerManagementService.update(updateFlowerRequest))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<FlowerResponse> {
        flowerManagementService.deleteById(id)
        return ResponseEntity.noContent().build()
    }


    companion object {
        const val BASE_FLOWER_URL = "api/v1/flower"
    }
}