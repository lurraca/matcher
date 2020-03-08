package com.lurraca.matcher.v1.apiclient

import com.lurraca.matcher.v1.models.Company
import com.lurraca.matcher.v1.models.Contact
import com.lurraca.matcher.v1.models.Representative
import org.json.JSONArray
import org.json.JSONObject

fun parseCompanies(jsonArray: JSONArray): List<Company> {
    return jsonArray.map { companyJSON ->
        val companyContactJSON: JSONObject = (companyJSON as JSONObject)["CONTACT"] as JSONObject
        val company = Company(
                companyJSON["NAME"] as String,
                companyJSON["ADDRESS"] as String,
                Contact(companyContactJSON["NAME"] as String, companyContactJSON["EMAIL"] as String, companyContactJSON["PHONE"] as String)
        )
        company.latitude = companyJSON["LATITUDE"] as Double
        company.longitude = companyJSON["LONGITUDE"] as Double

        company
    }
}

fun parseRepresentatives(jsonArray: JSONArray): List<Representative> {
    return jsonArray.map { representativeJSON ->
        (representativeJSON as JSONObject)
        val representative = Representative(
                representativeJSON["name"] as String,
                representativeJSON["email"] as String,
                representativeJSON["phone"] as String
        )
        val location = (representativeJSON["location"] as String).split(", ")
        representative.latitude = location.first().toDouble()
        representative.longitude = location.last().toDouble()

        representative
    }
}
