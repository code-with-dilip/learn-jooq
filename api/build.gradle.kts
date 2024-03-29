import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
val groovyVersion: String by project
val kotlinLoggingVersion: String by project

plugins {
    groovy
    application
    id("org.springframework.boot") version "2.2.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    kotlin("jvm") version "1.3.50"
    kotlin("plugin.spring") version "1.3.50"
}
group = "com.example"
version = "0.0.1-SNAPSHOT"
application {
    mainClassName = "com.learnjooq.LearnJooqApplicationKt"
}



java.sourceCompatibility = JavaVersion.VERSION_11



repositories {
    mavenCentral()
}
dependencies {
    implementation(project(":database"))
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    //logging
    implementation("io.github.microutils:kotlin-logging:$kotlinLoggingVersion"){
        exclude("kotlin-stdlib")
        exclude("kotlin-stdlib-common")
    }

    //postgres
    implementation("org.postgresql:postgresql:42.2.8")

    //test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.spockframework:spock-core:$groovyVersion")
    testImplementation("org.spockframework:spock-spring:$groovyVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

sourceSets {
    test {
        withConvention(GroovySourceSet::class) {
            groovy {
                setSrcDirs(listOf("src/test/unit", "src/test/intg"))
            }
        }
    }
}
