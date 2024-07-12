package com.bismark.flower_apis.dao

import com.bismark.flower_apis.domain.Flower
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FlowerDao : JpaRepository<Flower, Long>