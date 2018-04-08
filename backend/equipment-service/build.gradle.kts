group = "rent.project.backend"
version = "1.0-SNAPSHOT"

plugins {
    java
    application
    id("io.spring.dependency-management") version "1.0.4.RELEASE"
    id("org.springframework.boot") version "2.0.0.RELEASE"
    id("org.flywaydb.flyway") version "5.0.7"
}

application {
    mainClassName = "ru.kuzmin.rent.order.Application"
}

repositories {
    jcenter()
}

dependencies {
    compile("org.springframework.boot:spring-boot-starter-jdbc")
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("mysql:mysql-connector-java:5.1.6")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

flyway {
    url = "jdbc:mysql://localhost:3306/equipmentservice"
    user = "root"
    password = "root"
}