package com.insportfolio.portfolio.presentation.dto

import com.insportfolio.portfolio.domain.entity.Introduction

data class IntroductionDTO(
    val content: String
) {
    constructor(introduction: Introduction) : this(
        content = introduction.content
    )
}