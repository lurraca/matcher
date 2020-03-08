package com.lurraca.matcher.services

import com.lurraca.matcher.models.Company
import com.lurraca.matcher.models.Contact
import com.lurraca.matcher.models.Representative
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class OpportunityServiceImplTest {

    private val opportunityService = OpportunityServiceImpl()

    @Test
    fun `It should return the closest match between a single representative and mutiple companies`() {
        val representative = Representative("Michael", "michael@test.com", "koo-aid")
        representative.latitude = 55.370775
        representative.longitude = -7.308923

        //Around 640KM Distance
        val company640KM = Company("company1", "Far Away", Contact("John", "john@test.com", "555-444-9999"))
        company640KM.latitude = 51.509865
        company640KM.longitude = -0.118092


        //Around 5000KM Distance
        val company5000KM = Company("company2", "Not Close", Contact("Alice", "alice@test.com", "111-333-0000"))
        company5000KM.latitude = 40.730610
        company5000KM.longitude = -73.935242

        //Around 50KM Distance
        val company50KM = Company("company 50km", "Not Close", Contact("Alice", "alice@test.com", "111-333-0000"))
        company50KM.latitude = 54.886760
        company50KM.longitude =-7.340844

        val opportunities = opportunityService.listOpportunities(listOf<Representative>(representative), listOf<Company>(company640KM, company5000KM,company50KM))
        assertEquals(1, opportunities.size)
        assertEquals(representative.name, opportunities.first().representative.name)
        assertEquals(company50KM.name, opportunities.first().company.name)
    }

    @Test
    fun `It should return the closest match between multiple representatives and a single company`() {
        val representative = Representative("Michael", "michael@test.com", "koo-aid")
        representative.latitude = 55.370775
        representative.longitude = -7.308923

        val representative2 = Representative("Rob", "rob@test.com", "koo-aid")
        representative2.latitude = 51.525967
        representative2.longitude = -0.088225

        val company = Company("company1", "Far Away", Contact("John", "john@test.com", "555-444-9999"))
        company.latitude = 51.509865
        company.longitude = -0.118092

        val opportunities = opportunityService.listOpportunities(listOf<Representative>(representative, representative2), listOf<Company>(company))
        assertEquals(1, opportunities.size)
        assertEquals(representative2.name, opportunities.first().representative.name)
        assertEquals(company.name, opportunities.first().company.name)
    }

    @Test
    fun `It should return matches of multiple representatives and multiple companies by closest`() {
        val representative = Representative("Rob", "rob@test.com", "koo-aid")
        representative.latitude = 51.525967
        representative.longitude = -0.088225

        // 2.75KM Away
        val company = Company("company1", "Far Away", Contact("John", "john@test.com", "555-444-9999"))
        company.latitude = 51.509865
        company.longitude = -0.118092

        // .38KM Away
        val company3 = Company("company3", "Close", Contact("Kate", "kate@test.com", "555-444-9999"))
        company3.latitude =  51.527875
        company3.longitude = -0.083641

        val representative2 = Representative("Michael", "michael@test.com", "koo-aid")
        representative2.latitude = 55.370775
        representative2.longitude = -7.308923

        //53 KM Away
        val company2 = Company("company 2", "Not Close", Contact("Alice", "alice@test.com", "111-333-0000"))
        company2.latitude = 54.886760
        company2.longitude =-7.340844

        val opportunities = opportunityService.listOpportunities(listOf<Representative>(representative, representative2), listOf<Company>(company2, company, company3))
        assertEquals(2, opportunities.size)
        assertEquals(representative, opportunities.first().representative)
        assertEquals(company3, opportunities.first().company)

        assertEquals(representative2, opportunities.last().representative)
        assertEquals(company2, opportunities.last().company)
    }

    @Test
    fun `It should not pair the same entity more than once`() {
        val representative = Representative("Rob", "rob@test.com", "koo-aid")
        representative.latitude = 51.525967
        representative.longitude = -0.088225

        val representative2 = Representative("Jules", "jules@test.com", "koo-aid")
        representative2.latitude = 51.535967
        representative2.longitude = -0.088225

        val company = Company("company1", "Far Away", Contact("John", "john@test.com", "555-444-9999"))
        company.latitude = 51.509865
        company.longitude = -0.118092

        val opportunities = opportunityService.listOpportunities(listOf<Representative>(representative, representative2), listOf<Company>(company))

        assertEquals( 1, opportunities.size)
        assertEquals(representative, opportunities.first().representative)
    }

    @Test
    fun `It should not return matches that are not under 100KM Distance`() {
        val representative = Representative("hey", "ho", "koo-aid")
        representative.latitude = 55.370775
        representative.longitude = -7.308923

        //Around 640KM Distance
        val company640KM = Company("company1", "Far Away", Contact("John", "john@test.com", "555-444-9999"))
        company640KM.latitude = 51.509865
        company640KM.longitude = -0.118092


        //Around 5000KM Distance
        val company5000KM = Company("company2", "Not Close", Contact("Alice", "alice@test.com", "111-333-0000"))
        company5000KM.latitude = 40.730610
        company5000KM.longitude = -73.935242


        val opportunities = opportunityService.listOpportunities(listOf<Representative>(representative), listOf<Company>(company640KM, company5000KM))
        assertEquals(0, opportunities.size)
    }


}
