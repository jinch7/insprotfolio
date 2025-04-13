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
                title = "SQL開発者(SQL개발자)",
                description = "データベース、SQLなど",
                host = "韓国データ産業振興院(한국데이터산업진흥원)",
                achievedDate = LocalDate.of(2023, 7, 1),
                isActive = true,
            ),
            Achievement(
                title = "情報処理技師(정보처리기사)",
                description = "データ構造、データベース、オペレーティングシステムなど、日本の「応用情報技術者資格」相当",
                host = "韓国産業人力公団(한국산업인력공단)",
                achievedDate = LocalDate.of(2023, 11, 1),
                isActive = true,
            ),
            Achievement(
                title = "日本語能力試験　N2",
                description = "98点、2025年7月に日本語能力試験　N1を受ける予定",
                host = "日本国際交流基金",
                achievedDate = LocalDate.of(2024, 8, 1),
                isActive = true,
            ),
            Achievement(
                title = "JPT日本語能力試験",
                description = "635点、日本語能力試験　N1(660点相当)、N2(525点相当)の間",
                host = "YBM",
                achievedDate = LocalDate.of(2024, 9, 1),
                isActive = true,
            )
        )
        achievementRepository.saveAll(achievements)

        val introductions = mutableListOf<Introduction>(
            Introduction(
                content = "真面目で、新しいことに挑戦し、成長しようとする向上心を持っています。",
                isActive = true
            ),
            Introduction(
                content = "技術のための技術ではなく、ビジネス問題を解決するための技術に努めます。",
                isActive = true
            ),
            Introduction(content = "チームワークを大切にするエンジニアです。", isActive = true),
        )
        introductionRepository.saveAll(introductions)

        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/jinch7", isActive = true)
        )
        linkRepository.saveAll(links)

        val experience1 = Experience(
            title = "東亜大学(동아대학교)",
            description = "経営学専攻",
            startYear = 2015,
            startMonth = 3,
            endYear = 2025,
            endMonth = 2,
            isActive = true,
        )
//        experience1.addDetails(
//            mutableListOf(
//                ExperienceDetail(content = "GPA 4.3/4.5", isActive = true),
//                ExperienceDetail(content = "비즈니스 연구 학회 활동", isActive = true),
//            )
//        )

        val experience2 = Experience(
            title = "東亜大学(동아대학교)",
            description = "コンピューター工学専攻",
            startYear = 2025,
            startMonth = 4,
            endYear = null,
            endMonth = null,
            isActive = true,
        )
//        experience2.addDetails(
//            mutableListOf(
//                ExperienceDetail(content = "유기묘 위치 공유 서비스 개발", isActive = true),
//                ExperienceDetail(content = "신입 교육 프로그램 대상 수상", isActive = true),
//            )
//        )

        val experience3 = Experience(
            title = "KITA-SES(韓国貿易協会-Data Science Academy 釜山)",
            description = "ウェブ開発クラウド専門家過程24ー1期",
            startYear = 2024,
            startMonth = 4,
            endYear = 2024,
            endMonth = 12,
            isActive = true,
        )
        experience3.addDetails(
            mutableListOf(
                ExperienceDetail(content = "チームプロジェクトリーダー担当", isActive = true),
            )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2, experience3))

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
        val aws = Skill(name = "AmazonWebService", type = SkillType.TOOL.name, isActive = true)
        val gcp = Skill(name = "GoogleCloudPlatform", type = SkillType.TOOL.name, isActive = true)
        val docker = Skill(name = "Docker", type = SkillType.TOOL.name, isActive = true)
        skillRepository.saveAll(
            mutableListOf(
                java, kotlin, python, js,
                spring, react, django, mysql, oracle, firebase, h2, vscode, intelliJ, sts, dbeaver, aws, gcp, docker
            )
        )

        val project1 = Project(
            name = "農産物ショッピングモール 「くたモン」",
            description = "都市のコンシューマーと生産地をつなぎ、新鮮な商品をコンシューマーに届け、関連レシピも一緒に提供するショッピングモール 「くたモン」",
            startYear = 2024,
            startMonth = 8,
            endYear = 2024,
            endMonth = 10,
            isActive = true,
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "購入者と販売者の登録、農産物の売買、購入者と販売者間のチャット、お店の管理ページ、農産物関連レシピ提供", url = null, isActive = true),
                ProjectDetail(content = "チームリーダ、プロジェクトの企画、ERDの設計、注文及びレシピ関連機能、サイト全般的なデザイン実装担当", url = null, isActive = true),

                )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = spring),
                ProjectSkill(project = project1, skill = mysql),
                ProjectSkill(project = project1, skill = js)
            )
        )

        val project2 = Project(
            name = "仮想通貨トレードボット",
            description = "OpenAI APIを活用して韓国の仮想通貨取引サービスであるUpbitで自動、リアルタイムで取引するトレードボット",
            startYear = 2025,
            startMonth = 2,
            endYear = 2025,
            endMonth = 3,
            isActive = true
        )
        project2.addDetails(
            mutableListOf(
                ProjectDetail(content = "プロジェクトの企画、設計、実装、デプロイ", url = null, isActive = true),
                ProjectDetail(content = "最高収益率12%達成したこともあります。", url = null, isActive = true),

                )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = python),
                ProjectSkill(project = project2, skill = aws),
            )
        )

        val project3 = Project(
            name = "今ご覧のポートフォリオサイト",
            description = "KotlinとSpringBootを活用したポートフォリオサイト",
            startYear = 2025,
            startMonth = 3,
            endYear = 2025,
            endMonth = 4,
            isActive = true
        )
        project3.addDetails(
            mutableListOf(
                ProjectDetail(content = "GCPフリーティアを利用する上で、メモリ不足の問題を解決するためにswapメモリを活用", url = null, isActive = true),
                ProjectDetail(content = "htmlにハードコーディングするのではなく、管理者ページを構築してポートフォリオの内容を追加、修正、削除できるようにしました。", url = null, isActive = true),
                ProjectDetail(content = "訪問者情報の照会と訪問者数のカウント", url = null, isActive = true),

                )
        )
        project3.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project3, skill = kotlin),
                ProjectSkill(project = project3, skill = spring),
                ProjectSkill(project = project3, skill = docker),
                ProjectSkill(project = project3, skill = gcp),
            )
        )
        projectRepository.saveAll(mutableListOf(project1, project2, project3))

        val account = Account(
            loginId = "admin",
            pw = "\$2a\$10\$G0CrNpUeHdmhaaDao4P7hOsdzwhHbdn.HEzE2AJTVZnX6NMH1pvaq"
        )
        accountRepository.save(account)
    }
}