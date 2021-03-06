package com.lurraca.matcher

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
@SpringBootApplication
@EnableConfigurationProperties(ApiProperties::class)
class MatcherApplication

fun main(args: Array<String>) {
    runApplication<MatcherApplication>(*args)
}
