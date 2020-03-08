package com.lurraca.matcher

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "api")
class ApiProperties {
    lateinit var companiesEndpoint: String
    lateinit var representativesEndpoint: String
}