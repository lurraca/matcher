package com.lurraca.matcher.controllers

import com.lurraca.matcher.AppProperties
import com.lurraca.matcher.apiclient.ApiClient
import com.lurraca.matcher.models.Company
import com.lurraca.matcher.models.Contact
import com.lurraca.matcher.models.Opportunity
import com.lurraca.matcher.models.Representative
import com.lurraca.matcher.services.OpportunityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OpportunityController {

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

