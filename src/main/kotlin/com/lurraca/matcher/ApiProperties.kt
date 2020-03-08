package com.lurraca.matcher

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix="api")
class ApiProperties  {
    lateinit var companiesEndpoint: String
    lateinit var representativesEndpoint: String
}