package com.insportfolio.portfolio.admin.context.project.service

import com.insportfolio.portfolio.admin.data.TableDTO
import com.insportfolio.portfolio.admin.exception.AdminBadRequestException
import com.insportfolio.portfolio.domain.entity.Project
import com.insportfolio.portfolio.domain.entity.ProjectDetail
import com.insportfolio.portfolio.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class AdminProjectService(
    private val projectRepository: ProjectRepository
) {
    fun getProjectTable(): TableDTO {
        val classInfo = Project::class
        val entities = projectRepository.findAll()

        return TableDTO.from(classInfo, entities, "details", "skill")
    }

    fun getProjectDetailTable(id: Long?): TableDTO {
        val classInfo = ProjectDetail::class
        val entities = if (id != null) projectRepository.findById(id)
            .orElseThrow { throw AdminBadRequestException("No data was found for ID ${id}.") }
            .details else emptyList()

        return TableDTO.from(classInfo, entities)
    }
}