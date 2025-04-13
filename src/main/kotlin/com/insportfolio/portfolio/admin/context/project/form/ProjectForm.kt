package com.insportfolio.portfolio.admin.context.project.form

import com.insportfolio.portfolio.domain.entity.Project
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

data class ProjectForm(
    @field:NotBlank(message = "Required value.")
    val name: String,

    @field:NotBlank(message = "Required value.")
    val description: String,

    @field:Positive(message = "Must be greater than 0.")
    val startYear: Int,

    @field:Min(value = 1, message = "The minimum value is 1.")
    @field:Max(value = 12, message = "The maximum value is 12.")
    val startMonth: Int,

    val endYear: Int?,

    val endMonth: Int?,

    val isActive: Boolean,

    val details: List<ProjectDetailForm>?
) {
    fun toEntity(): Project {
        return Project(
            name = this.name,
            description = this.description,
            startYear = this.startYear,
            startMonth = this.startMonth,
            endYear = this.endYear,
            endMonth = this.endMonth,
            isActive = this.isActive,
        )
    }
}