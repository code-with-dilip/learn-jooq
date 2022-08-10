package com.learnjooq

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [JooqAutoConfiguration::class])

class LearnJooqApplication
    fun main(args: Array<String>) {
        runApplication<LearnJooqApplication>(*args)
    }

