group = "rent.project.backend"
version = "1.0-SNAPSHOT"

plugins {
    java
    application
    id("io.spring.dependency-management") version "1.0.4.RELEASE"
    id("org.springframework.boot") version "2.0.0.RELEASE"
}

application {
    mainClassName = "ru.kuzmin.rent.order.Application"
}

repositories {
    mavenLocal()
    jcenter()
}

dependencies {
    compile("rent.project.backend:order-sdk:0.0.1-SNAPSHOT")
    compile("org.springframework.boot:spring-boot-starter-web")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}