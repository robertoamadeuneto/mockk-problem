plugins {
    kotlin("jvm") version "1.3.71"
    kotlin("plugin.spring") version "1.3.71"
    id("org.springframework.boot") version "2.2.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("com.adarshr.test-logger") version "2.0.0"
}

group = "com.mockkproblem"
version = "1.0"

val mockkVersion = "1.10.0"
val kotlintestVersion = "3.3.2"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("org.springframework.boot:spring-boot-starter")

    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("io.kotlintest:kotlintest-runner-junit5:$kotlintestVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

configurations.all {
    exclude(group = "junit")
    exclude(group = "org.mockito")
}

repositories {
    mavenCentral()
    maven("https://repo.spring.io/milestone")
    maven("https://repo.spring.io/snapshot")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=enable")
        }
    }

    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=enable")
        }
    }

    test {
        useJUnitPlatform()
        systemProperty("spring.profiles.active", "local")
    }

    bootJar {
        archiveFileName.set("app.jar")
    }
}

testlogger {
    setTheme("mocha")
}
