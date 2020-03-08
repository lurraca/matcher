package com.lurraca.matcher.v1.models

data class Contact(override val name: String, override val email: String, override val phone: String) : Person