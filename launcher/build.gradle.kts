import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

tasks.named<ShadowJar>("shadowJar") {
    archiveBaseName.set("shadow")
    archiveFileName.set("launcher.jar")
    mergeServiceFiles()
    manifest {
        attributes["Main-Class"] = "me.dgahn.LauncherKt"
    }
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

dependencies {
    implementation(EncryptLibs.jBCrypt)
    implementation(SpringLibs.bootStarterValidation)
    implementation(HibernateLibs.jacksonDataType)

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:2.4.4")
    implementation("com.querydsl:querydsl-jpa:4.2.2")
    kapt("com.querydsl:querydsl-apt:4.2.2:jpa")

    testImplementation(SpringLibs.bootStarterTest)
    testImplementation(TestLibs.kotestTestContainer)
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            element = "SOURCEFILE"

            limit {
                counter = "LINE"
                value = "COVEREDRATIO"
                minimum = (0.8).toBigDecimal()
            }

            excludes = listOf()
        }
    }
}
