group = "rent.project.backend"
version = "0.0.1-SNAPSHOT"

plugins {
    java
    maven
}

repositories {
    mavenLocal()
    jcenter()
}

dependencies {
    compile("com.fasterxml.jackson.core:jackson-core:2.9.5")
    compile("com.fasterxml.jackson.core:jackson-annotations:2.9.5")
    compile("com.fasterxml.jackson.core:jackson-databind:2.9.5")
    compile("org.apache.kafka:kafka-clients:1.1.0")
    testCompile("junit:junit:4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}