package com.lurraca.matcher.v1.apiclient
import com.lurraca.matcher.AppProperties
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
    private lateinit var appProperties: AppProperties

    private val client = OkHttpClient()

    fun getCompanies(): List<Company> {
        val companies = mutableListOf<Company>()

        val request = Request.Builder()
                .url(appProperties.apiCompaniesEndpoint)
                .build()
        var responseJSON: JSONArray

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            responseJSON = JSONArray(response.body!!.string())

            for (i in 0 until responseJSON.length()) {
                val companyJSON = responseJSON.getJSONObject(i)
                val companyContactJSON = companyJSON["CONTACT"] as JSONObject
                val company = Company(
                        companyJSON["NAME"] as String,
                        companyJSON["ADDRESS"] as String,
                        Contact(companyContactJSON["NAME"] as String, companyContactJSON["EMAIL"] as String, companyContactJSON["PHONE"] as String)
                )
                company.latitude = companyJSON["LATITUDE"] as Double
                company.longitude = companyJSON["LONGITUDE"] as Double
                companies.add(company)
            }
        }
        return companies
    }

    fun getRepresentatives(): List<Representative> {
        val representatives = mutableListOf<Representative>()

        val request = Request.Builder()
                .url(appProperties.apiRepresentativesEndpoint)
                .build()
        var responseJSON: JSONArray

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            responseJSON = JSONArray(response.body!!.string())

            for (i in 0 until responseJSON.length()) {
                val representativeJSON = responseJSON.getJSONObject(i)
                val rep = Representative(representativeJSON["name"] as String, representativeJSON["email"] as String, representativeJSON["phone"] as String)
                val location = (representativeJSON["location"] as String).split(", ")
                rep.latitude = location.first().toDouble()
                rep.longitude = location.last().toDouble()

                representatives.add(rep)
            }
        }
        return representatives
    }
}