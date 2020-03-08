package com.lurraca.matcher

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class AppProperties  {
    @Value("\${api.companies.endpoint}")
    lateinit var apiCompaniesEndpoint: String

    @Value("\${api.representatives.endpoint}")
    lateinit var apiRepresentativesEndpoint: String
}