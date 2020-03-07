package com.lurraca.matcher.controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class OpportunityControllerTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate;


    @Test
    fun testOpportunitiesEndpoint() {
        val response = testRestTemplate.getForEntity("/api/v1/opportunities", String::class.java)
        assertNotNull(response)
        assertEquals(response.statusCode, HttpStatus.OK)
        assertEquals(response.body, testJson())
    }

    fun testJson() =
            "[{\"representative\":{\"name\":\"hey\",\"email\":\"ho\",\"phone\":\"koo-aid\"},\"company\":{\"name\":\"hi\",\"address\":\"haha\",\"contact\":{\"name\":\"wow\",\"email\":\"yo\",\"phone\":\"thing\"}}},{\"representative\":{\"name\":\"hey\",\"email\":\"ho\",\"phone\":\"koo-aid\"},\"company\":{\"name\":\"hi\",\"address\":\"haha\",\"contact\":{\"name\":\"wow\",\"email\":\"yo\",\"phone\":\"thing\"}}}]"

}