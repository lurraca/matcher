package com.lurraca.matcher.models

import com.fasterxml.jackson.annotation.JsonIgnore

data class Representative(override val name: String, override val email: String, override val phone: String) : Person {
    @JsonIgnore
    var latitude: Double = 0.0
    @JsonIgnore
    var longitude: Double = 0.0
}
