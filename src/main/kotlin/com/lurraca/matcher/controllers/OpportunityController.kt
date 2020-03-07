package com.lurraca.matcher.controllers

import com.lurraca.matcher.models.Company
import com.lurraca.matcher.models.Contact
import com.lurraca.matcher.models.Opportunity
import com.lurraca.matcher.models.Representative
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OpportunityController{

    @GetMapping("/api/v1/opportunities")
    fun opportunities() =
            Opportunity(
                    Representative("hey","ho", "koo-aid"),
                    Company("hi", "haha", Contact("wow", "yo", "thing"))
            )
}

