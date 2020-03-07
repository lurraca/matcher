package com.lurraca.matcher.services

import com.lurraca.matcher.models.Opportunity

interface OpportunityService {
    fun listOpportunities(): List<Opportunity>
}
