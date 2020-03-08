package com.lurraca.matcher.v1.controllers

import com.lurraca.matcher.v1.apiclient.ApiClient
import com.lurraca.matcher.v1.models.Opportunity
import com.lurraca.matcher.v1.services.OpportunityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OpportunitiesController {

    @Autowired
    lateinit var opportunityService: OpportunityService

    @Autowired
    lateinit var apiClient: ApiClient

    @GetMapping("/api/v1/opportunities")
    @ResponseBody
    fun opportunities() : List<Opportunity> {
        return opportunityService.listOpportunities(apiClient.getRepresentatives(), apiClient.getCompanies())
    }

}

