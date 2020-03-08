package com.lurraca.matcher.v1.models

import com.fasterxml.jackson.annotation.JsonIgnore

data class Company(val name:String, val address:String, val contact:Person) {
    @JsonIgnore
    var latitude: Double = 0.0
    @JsonIgnore
    var longitude: Double = 0.0
}