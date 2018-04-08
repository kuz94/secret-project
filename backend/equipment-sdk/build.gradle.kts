group = "rent.project.backend"
version = "1.0-SNAPSHOT"

plugins {
    java
}

repositories {
    jcenter()
}

dependencies {
    compile("com.fasterxml.jackson.core:jackson-core:2.9.4")
    compile("com.fasterxml.jackson.core:jackson-annotations:2.9.4")
    compile("com.fasterxml.jackson.core:jackson-databind:2.9.4")
    compile("org.apache.kafka:kafka-clients:1.0.1")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
