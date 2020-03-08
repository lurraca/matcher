package com.lurraca.matcher.controllers

import com.lurraca.matcher.v1.controllers.OpportunitiesController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @Autowired
    private lateinit var apiOpportunitiesController: OpportunitiesController

    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("opportunities", apiOpportunitiesController.opportunities())
        return "home"
    }

}