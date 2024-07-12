package com.bismark.flower_apis.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator

@Entity
data class Flower(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = FLOWER_SEQUENCE)
    @SequenceGenerator(name = FLOWER_SEQUENCE, sequenceName = FLOWER_SEQUENCE, allocationSize = 1)
    val id: Long = 0,
    val name: String,
    val price: Double,
    val description: String,
    val url: String,
    val createdDate: Long,
){
    companion object{
        const val FLOWER_SEQUENCE = "flower_sequence"
    }
}
