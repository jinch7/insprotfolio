package com.insportfolio.portfolio.domain

import com.insportfolio.portfolio.domain.constant.SkillType
import com.insportfolio.portfolio.domain.entity.*
import com.insportfolio.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class DataInitializer(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository,
    private val accountRepository: AccountRepository
) {

    @PostConstruct
    fun initializeData() {
        println("스프링이 실행되었습니다. 테스트 데이터를 초기화합니다.")

        val achievements = mutableListOf<Achievement>(
            Achievement(
                title = "2025 Catkao 해커톤 대상",
                description = "코양이 쇼핑물 검색 서비스의 아키텍처, 데이터 모델링, API 개발 역할 담당",
                host = "캣카오",
                achievedDate = LocalDate.of(2025, 3, 1),
                isActive = true,
            ),
            Achievement(
                title = "정보처리기사",
                description = "자료구조, 데이터베이스, 운영체제 등",
                host = "한국산업인력공단",
                achievedDate = LocalDate.of(2025, 4, 1),
                isActive = true,
            )
        )
        achievementRepository.saveAll(achievements)

        val introductions = mutableListOf<Introduction>(
            Introduction(content = "주도적으로 문제를 찾고 해결하는 고양이입니다.", isActive = true),
            Introduction(content = "기술을 휘한 기술이 아닌, 비즈니스 문제를 해결하기 위한 기술을 추구합니다.", isActive = true),
            Introduction(content = "기존 소스를 리팩토링하여 더 나은 코드로 개선하는 작업을 좋아합니다.", isActive = true),
        )
        introductionRepository.saveAll(introductions)

        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/jinch7", isActive = true)
        )
        linkRepository.saveAll(links)

        val experience1 = Experience(
            title = "캣홀릭 대학교(CatHolic Univ)",
            description = "경영학 전공",
            startYear = 2015,
            startMonth = 3,
            endYear = 2025,
            endMonth = 2,
            isActive = true,
        )
        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "GPA 4.3/4.5", isActive = true),
                ExperienceDetail(content = "비즈니스 연구 학회 활동", isActive = true),
            )
        )

        val experience2 = Experience(
            title = "주식회사 캣카오(Catkao Corp.)",
            description = "마케팅 데이터 분석 팀 리더",
            startYear = 2025,
            startMonth = 4,
            endYear = null,
            endMonth = null,
            isActive = true,
        )
        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content = "유기묘 위치 공유 서비스 개발", isActive = true),
                ExperienceDetail(content = "신입 교육 프로그램 대상 수상", isActive = true),
            )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2))

        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val python = Skill(name = "Python", type = SkillType.LANGUAGE.name, isActive = true)
        val js = Skill(name = "JavaScript", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val react = Skill(name = "React", type = SkillType.FRAMEWORK.name, isActive = true)
        val django = Skill(name = "Django", type = SkillType.FRAMEWORK.name, isActive = true)
        val mysql = Skill(name = "MySql", type = SkillType.DATABASE.name, isActive = true)
        val oracle = Skill(name = "Oracle", type = SkillType.DATABASE.name, isActive = true)
        val firebase = Skill(name = "Firebase", type = SkillType.DATABASE.name, isActive = true)
        val h2 = Skill(name = "H2", type = SkillType.DATABASE.name, isActive = true)
        val vscode = Skill(name = "VisualStudioCode", type = SkillType.TOOL.name, isActive = true)
        val intelliJ = Skill(name = "intelliJ", type = SkillType.TOOL.name, isActive = true)
        val sts = Skill(name = "SpringToolSuite", type = SkillType.TOOL.name, isActive = true)
        val dbeaver = Skill(name = "DBeaver", type = SkillType.TOOL.name, isActive = true)
        val aws = Skill(name = "AWS", type = SkillType.TOOL.name, isActive = true)
        val gcp = Skill(name = "GoogleCloudPlatform", type = SkillType.TOOL.name, isActive = true)
        skillRepository.saveAll(
            mutableListOf(
                java, kotlin, python, js,
                spring, react, django, mysql, oracle, firebase, h2, vscode, intelliJ, sts, dbeaver, aws, gcp
            )
        )

        val project1 = Project(
            name = "유기묘 발견 정보 공유 서비스",
            description = "유기묘 위치의 실시간 공유, 임시 보호까지 연결하는 서비스",
            startYear = 2025,
            startMonth = 4,
            endYear = 2025,
            endMonth = 4,
            isActive = true,
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "구글 맵스를 활용한 유기묘 발견 지역 정보 제공 API 개발", url = null, isActive = true),
                ProjectDetail(content = "Redis를 적용해서 인기 게시글의 조회 속도를 50% 개선", url = null, isActive = true),

                )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = spring),
                ProjectSkill(project = project1, skill = mysql),
                ProjectSkill(project = project1, skill = aws)
            )
        )

        val project2 = Project(
            name = "반려동물 홈 카메라 움직임 감지 분석",
            description = "카메라에서 서버로 전달되는 신호를 분석해서 이상 움직임이 감지될 경우 클라이언트에게 알림을 모내주는 ㅅ서비스",
            startYear = 2025,
            startMonth = 4,
            endYear = null,
            endMonth = null,
            isActive = true
        )
        project2.addDetails(
            mutableListOf(
                ProjectDetail(content = "PIL(Pillow)를 활용해서 이미지 분석", url = null, isActive = true),
                ProjectDetail(content = "알림 발송을 비동기 처리해서 이미지 분석과 알림 발송 기능간 의존도 개선", url = null, isActive = true),

                )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = python),
                ProjectSkill(project = project2, skill = django),
                ProjectSkill(project = project2, skill = oracle),
                ProjectSkill(project = project2, skill = gcp)
            )
        )
        projectRepository.saveAll(mutableListOf(project1, project2))

        val account = Account(
            loginId = "admin",
            pw = "\$2a\$10\$G0CrNpUeHdmhaaDao4P7hOsdzwhHbdn.HEzE2AJTVZnX6NMH1pvaq"
        )
        accountRepository.save(account)
    }
}