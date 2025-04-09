package com.insportfolio.portfolio.domain.repository

import com.insportfolio.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long>