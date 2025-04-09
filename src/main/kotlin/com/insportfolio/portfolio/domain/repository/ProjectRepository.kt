package com.insportfolio.portfolio.domain.repository

import com.insportfolio.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long>