package com.insportfolio.portfolio.admin.context.project.controller

import com.insportfolio.portfolio.admin.context.project.form.ProjectSkilllForm
import com.insportfolio.portfolio.admin.context.project.service.AdminProjectSkillService
import com.insportfolio.portfolio.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/api/projects/skills")
class AdminProjectSkillApiController(
    private val adminProjectSkillService: AdminProjectSkillService
) {
    @PostMapping
    fun postProjectSkill(@RequestBody @Validated form: ProjectSkilllForm): ResponseEntity<Any> {
        adminProjectSkillService.save(form)

        return ApiResponse.successCreate()
    }

    @DeleteMapping("/{id}")
    fun deleteProjectSkill(@PathVariable id: Long): ResponseEntity<Any> {
        adminProjectSkillService.delete(id)

        return ApiResponse.successDelete()
    }
}