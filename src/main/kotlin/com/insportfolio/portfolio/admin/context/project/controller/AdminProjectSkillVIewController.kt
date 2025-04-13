package com.insportfolio.portfolio.admin.context.project.controller

import com.insportfolio.portfolio.admin.context.project.service.AdminProjectSkillService
import com.insportfolio.portfolio.admin.data.FormElementDTO
import com.insportfolio.portfolio.admin.data.SelectFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/project/skill")
class AdminProjectSkillVIewController(
    private val adminProjectSkillService: AdminProjectSkillService,
) {
    @GetMapping
    fun projectSkill(model: Model): String {
        val projectList = adminProjectSkillService.getProjectList()
        val skillList = adminProjectSkillService.getSkillList()

        val fromElements = listOf<FormElementDTO>(
            SelectFormElementDTO("project", 8, projectList),
            SelectFormElementDTO("skill", 4, skillList),
        )
        model.addAttribute("fromElements", fromElements)

        val table = adminProjectSkillService.getProjectSkillTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)

        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuName", "projects"),
            Pair("pageName", table.name),
            Pair("editable", false),
            Pair("deletable", true),
            Pair("hasDetails", true),
        )
        model.addAllAttributes(pageAttributes)

        return "admin/page-table"
    }
}