allprojects {
    group = "com.learnjooq"

    repositories {
        jcenter()
        mavenLocal()
        mavenCentral()
    }
}


subprojects {
    buildscript {
        repositories {
            mavenCentral()
            maven {
                setUrl( "https://plugins.gradle.org/m2/")
            }
        }
    }
    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
    }
}
