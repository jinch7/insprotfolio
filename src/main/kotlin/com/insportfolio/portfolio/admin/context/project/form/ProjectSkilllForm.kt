package com.insportfolio.portfolio.admin.context.project.form

import jakarta.validation.constraints.NotBlank

data class ProjectSkilllForm(
    @field:NotBlank(message = "Required value.")
    val project: String,

    val skill: String
)