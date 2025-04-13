package com.insportfolio.portfolio.admin.context.experience.form

import com.insportfolio.portfolio.domain.entity.ExperienceDetail
import jakarta.validation.constraints.NotBlank

data class ExperienceDetailForm(
    val id: Long,

    @field:NotBlank(message = "Required value.")
    val content: String,

    val isActive: Boolean,
) {
    fun toEntity(): ExperienceDetail {
        return ExperienceDetail(
            content = this.content,
            isActive = this.isActive
        )
    }
}