package com.lurraca.matcher.v1.services

import com.lurraca.matcher.v1.models.Company
import com.lurraca.matcher.v1.models.Opportunity
import com.lurraca.matcher.v1.models.Representative
import com.lurraca.matcher.utils.GeoPoint
import com.lurraca.matcher.utils.distanceInKM
import org.springframework.stereotype.Service

@Service
class OpportunityServiceImpl : OpportunityService {

    override fun listOpportunities(representatives: List<Representative>, companies: List<Company>): List<Opportunity> {
        val tempRepresentatives = representatives.toMutableList()
        val tempCompanies = companies.toMutableList()
        val opportunities = mutableListOf<Opportunity>()


        tempRepresentatives.forEach { representative ->
            val company = tempCompanies.filter { company ->
                distanceInKM(GeoPoint(representative.latitude, representative.longitude), GeoPoint(company.latitude, company.longitude)) < 100
            }.minBy { c ->
                distanceInKM(GeoPoint(representative.latitude, representative.longitude), GeoPoint(c.latitude, c.longitude))
            }
            if (company != null) opportunities.add(Opportunity(representative, company))
            tempCompanies.remove(company)
        }

        return opportunities
    }
}