val jooqVersion: String by project
val postgresDriverVersion: String by project

plugins {
    groovy
    application
    id("org.springframework.boot") version "2.1.5.RELEASE"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    kotlin("jvm") version "1.3.50"
    kotlin("plugin.spring") version "1.3.50"
}

java.sourceCompatibility = JavaVersion.VERSION_11

application {
    mainClassName = "com.learnjooq.LearnJooqApplication"
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.springframework.boot:spring-boot-starter-jooq")

    implementation ("org.jooq:jooq:$jooqVersion")
    implementation ("org.postgresql:postgresql:$postgresDriverVersion")
    implementation ("org.simpleflatmapper:sfm-jooq:6.6.2") // For mapping jOOQ results onto POJOs
}
repositories {
    mavenCentral()
}