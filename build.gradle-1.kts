import nu.studer.gradle.jooq.*
import nu.studer.gradle.jooq.JooqEdition
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.2.0.RELEASE"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	kotlin("jvm") version "1.3.50"
	kotlin("plugin.spring") version "1.3.50"
    id ("nu.studer.jooq") version "3.0.2"
    id ("org.flywaydb.flyway") version "6.0.6"
}

group = "com.learnjooq"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-jooq")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	//flyway
	implementation("org.flywaydb:flyway-core")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    //postgres
	runtimeOnly("org.postgresql:postgresql")

    //jooq-runtime
    jooqRuntime("postgresql:postgresql:9.1-901.jdbc")
    implementation("nu.studer:gradle-jooq-plugin:3.0.2")

    //junit5
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

/*
jooq {
    version = "3.11.11"
    edition = JooqEdition.OSS
    "sample"(sourceSets["main"]) {
        jdbc {
            driver = "org.h2.Driver"
            url = "jdbc:h2:~/test;AUTO_SERVER=TRUE"
            user = "sa"
            password = ""
        }
    }
}
*/

//jooq {
//    version = "3.11.11"
//    edition = JooqEdition.OSS
//    "sample"(sourceSets["main"]) {
//        jdbc {
//            driver = "org.postgresql.Driver"
//            url = "jdbc:postgresql://localhost:5432/jooqtest"
//            user = "postgres"
//            password = "postgres"
//        }
//        generator {
//            name = 'org.jooq.util.DefaultGenerator'
//            strategy {
//                name = 'org.jooq.util.DefaultGeneratorStrategy'
//            }
//            database {
//                name = 'org.jooq.util.postgres.PostgresDatabase'
//                inputSchema = 'public'
//                customTypes {
//                    customType {
//                        name = 'com.fasterxml.jackson.databind.JsonNode'
//                        converter = 'csmart.api.config.db.PostgresJSONJacksonJsonNodeBinding'
//                    }
//                }
//                forcedTypes {
//                    forcedType {
//                        name = 'com.fasterxml.jackson.databind.JsonNode'
//                        expression = 'public\\.users\\.address'
//                    }
//                }
//            }
//            generate {
//                relations = true
//                deprecated = false
//                records = true
//                immutablePojos = false
//                fluentSetters = true
//            }
//            target {
//                packageName = 'csmart.db.gen'
//                directory = 'src/main/generated/java'
//            }
//        }
//    }
//}
