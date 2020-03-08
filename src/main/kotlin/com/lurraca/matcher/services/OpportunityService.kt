package com.lurraca.matcher.services

import com.lurraca.matcher.models.Company
import com.lurraca.matcher.models.Opportunity
import com.lurraca.matcher.models.Representative
import org.springframework.stereotype.Service

@Service
interface OpportunityService {
    fun listOpportunities(representatives: List<Representative>, companies: List<Company>): List<Opportunity>
}
