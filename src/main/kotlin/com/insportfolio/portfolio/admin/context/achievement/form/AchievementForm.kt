package com.insportfolio.portfolio.admin.context.achievement.form

import com.insportfolio.portfolio.domain.entity.Achievement
import jakarta.validation.constraints.NotBlank
import java.time.LocalDate

data class AchievementForm(
    @field:NotBlank(message = "Required value.")
    val title: String,

    @field:NotBlank(message = "Required value.")
    val description: String,

    @field:NotBlank(message = "Required value.")
    val host: String,

    @field:NotBlank(message = "Required value.")
    val achievedDate: String,

    val isActive: Boolean,
) {
    fun toEntity(): Achievement {
        return Achievement(
            title = this.title,
            description = this.description,
            host = this.host,
            achievedDate = LocalDate.parse(this.achievedDate),
            isActive = this.isActive
        )
    }

    fun toEntity(id: Long): Achievement {
        val achievement = this.toEntity()
        achievement.id = id

        return achievement
    }
}