package com.lurraca.matcher.v1.services

import com.lurraca.matcher.v1.models.Company
import com.lurraca.matcher.v1.models.Opportunity
import com.lurraca.matcher.v1.models.Representative
import org.springframework.stereotype.Service

@Service
interface OpportunityService {
    fun listOpportunities(representatives: List<Representative>, companies: List<Company>): List<Opportunity>
}
