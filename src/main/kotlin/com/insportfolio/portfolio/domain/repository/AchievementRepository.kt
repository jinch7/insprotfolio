package com.insportfolio.portfolio.domain.repository

import com.insportfolio.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository : JpaRepository<Achievement, Long> {

    // select * from achievement where is_active = :isActive
    fun findAllByIsActive(isActive: Boolean): List<Achievement>

}