package com.lurraca.matcher.v1.apiclient
import com.lurraca.matcher.ApiProperties
import com.lurraca.matcher.v1.models.Company
import com.lurraca.matcher.v1.models.Contact
import com.lurraca.matcher.v1.models.Representative
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.io.IOException

@Component
class ApiClient {
    @Autowired
    private lateinit var apiProperties: ApiProperties

    private val client = OkHttpClient()

    fun getCompanies(): List<Company> {
        var companies = mutableListOf<Company>()

        val request = Request.Builder()
                .url(apiProperties.companiesEndpoint)
                .build()
        var responseJSON: JSONArray

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            responseJSON = JSONArray(response.body!!.string())

            companies = responseJSON.map { companyJSON ->
                val companyContactJSON: JSONObject = (companyJSON as JSONObject)["CONTACT"] as JSONObject
                val company = Company(
                        companyJSON["NAME"] as String,
                        companyJSON["ADDRESS"] as String,
                        Contact(companyContactJSON["NAME"] as String, companyContactJSON["EMAIL"] as String, companyContactJSON["PHONE"] as String)
                )
                company.latitude = companyJSON["LATITUDE"] as Double
                company.longitude = companyJSON["LONGITUDE"] as Double
                company
            }.toMutableList()
        }
        return companies
    }

    fun getRepresentatives(): List<Representative> {
        var representatives = mutableListOf<Representative>()

        val request = Request.Builder()
                .url(apiProperties.representativesEndpoint)
                .build()
        var responseJSON: JSONArray

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            responseJSON = JSONArray(response.body!!.string())

            representatives = responseJSON.map { representativeJSON ->
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
            }.toMutableList()
        }
        return representatives
    }
}