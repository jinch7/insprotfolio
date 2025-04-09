package com.insportfolio.portfolio.domain.repository

import com.insportfolio.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository : JpaRepository<Introduction, Long>