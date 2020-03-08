package com.lurraca.matcher.controllers

import com.lurraca.matcher.v1.controllers.OpportunityController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @Autowired
    lateinit var apiOpportunityController: OpportunityController

    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("opportunities", apiOpportunityController.opportunities())
        return "home"
    }

}