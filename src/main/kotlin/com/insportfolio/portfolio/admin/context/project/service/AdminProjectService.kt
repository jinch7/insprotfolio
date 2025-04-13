package com.insportfolio.portfolio.admin.context.project.service

import com.insportfolio.portfolio.admin.context.project.form.ProjectForm
import com.insportfolio.portfolio.admin.data.TableDTO
import com.insportfolio.portfolio.admin.exception.AdminBadRequestException
import com.insportfolio.portfolio.domain.entity.Project
import com.insportfolio.portfolio.domain.entity.ProjectDetail
import com.insportfolio.portfolio.domain.repository.ProjectRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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

    @Transactional
    fun save(form: ProjectForm) {
        val projectDetails = form.details
            ?.map { detail -> detail.toEntity() }
            ?.toMutableList()

        val project = form.toEntity()
        project.addDetails(projectDetails)

        projectRepository.save(project)
    }

    @Transactional
    fun update(id: Long, form: ProjectForm) {
        val project = projectRepository.findById(id)
            .orElseThrow { throw AdminBadRequestException("No data was found for ID ${id}.") }

        project.update(
            name = form.name,
            description = form.description,
            startYear = form.startYear,
            startMonth = form.startMonth,
            endMonth = form.endMonth,
            endYear = form.endYear,
            isActive = form.isActive
        )

        val detailMap = project.details.map { it.id to it }.toMap()
        form.details?.forEach {
            val entity = detailMap.get(it.id)
            if (entity != null) {
                entity.update(
                    content = it.content,
                    url = it.url,
                    isActive = it.isActive
                )
            } else {
                project.details.add(it.toEntity())
            }
        }
    }
}