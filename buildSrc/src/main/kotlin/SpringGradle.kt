object SpringPlugin {
    const val dependencyManagement = "io.spring.dependency-management"
    const val boot = "org.springframework.boot"
}

object SpringVersion {
    const val dependencyManagement = "1.0.11.RELEASE"
    const val boot = "2.4.4"
    const val spring = "5.3.7"
}

object SpringLibs {
    const val bootStarterWebflux = "org.springframework.boot:spring-boot-starter-webflux:${SpringVersion.boot}"
    const val bootStarterWeb = "org.springframework.boot:spring-boot-starter-web:${SpringVersion.boot}"
    const val bootStarterValidation = "org.springframework.boot:spring-boot-starter-validation:${SpringVersion.boot}"
    const val bootStarterJpa = "org.springframework.boot:spring-boot-starter-data-jpa:${SpringVersion.boot}"
    const val bootStarterTest = "org.springframework.boot:spring-boot-starter-test:${SpringVersion.boot}"
    const val webMvc = "org.springframework:spring-webmvc:${SpringVersion.spring}"
}