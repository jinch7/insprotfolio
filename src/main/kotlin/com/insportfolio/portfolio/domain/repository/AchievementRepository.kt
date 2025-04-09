package com.insportfolio.portfolio.domain.repository

import com.insportfolio.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository : JpaRepository<Achievement, Long>