package com.lurraca.matcher.services

import com.lurraca.matcher.models.Company
import com.lurraca.matcher.models.Contact
import com.lurraca.matcher.models.Opportunity
import com.lurraca.matcher.models.Representative
import org.springframework.stereotype.Service

@Service
class OpportunityServiceImpl : OpportunityService {
    override fun listOpportunities(): List<Opportunity> {
        return listOf(
                Opportunity(
                        Representative("hey", "ho", "koo-aid"),
                        Company("hi", "haha", Contact("wow", "yo", "thing"))
                ),
                Opportunity(
                        Representative("hey", "ho", "koo-aid"),
                        Company("hi", "haha", Contact("wow", "yo", "thing"))
                )
        )
    }
}