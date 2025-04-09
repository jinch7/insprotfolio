package com.insportfolio.portfolio.domain.repository

import com.insportfolio.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long>