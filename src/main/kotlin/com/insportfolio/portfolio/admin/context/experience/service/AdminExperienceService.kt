package com.insportfolio.portfolio.admin.context.experience.service

import com.insportfolio.portfolio.admin.data.TableDTO
import com.insportfolio.portfolio.admin.exception.AdminBadRequestException
import com.insportfolio.portfolio.domain.entity.Experience
import com.insportfolio.portfolio.domain.entity.ExperienceDetail
import com.insportfolio.portfolio.domain.repository.ExperienceRepository
import org.springframework.stereotype.Service

@Service
class AdminExperienceService(
    private val experienceRepository: ExperienceRepository
) {
    fun getExperienceTable(): TableDTO {
        val classInfo = Experience::class
        val entities = experienceRepository.findAll()

        return TableDTO.from(classInfo, entities, "details")
    }

    fun getExperienceDetailTable(id: Long?): TableDTO {
        val classInfo = ExperienceDetail::class
        val entities = if (id != null) experienceRepository.findById(id)
            .orElseThrow { throw AdminBadRequestException("No data was found for ID ${id}.") }
            .details else emptyList()

        return TableDTO.from(classInfo, entities)
    }
}