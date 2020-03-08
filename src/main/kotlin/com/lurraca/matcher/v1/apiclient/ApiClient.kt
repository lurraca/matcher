package com.lurraca.matcher.v1.apiclient
import com.lurraca.matcher.ApiProperties
import com.lurraca.matcher.v1.models.Company
import com.lurraca.matcher.v1.models.Representative
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.io.IOException

@Component
class ApiClient {
    @Autowired
    private lateinit var apiProperties: ApiProperties

    private val client = OkHttpClient()

    fun getCompanies(): List<Company> {
        var companies = listOf<Company>()

        val request = Request.Builder()
                .url(apiProperties.companiesEndpoint)
                .build()
        var responseJSON: JSONArray

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            responseJSON = JSONArray(response.body!!.string())

            companies = parseCompanies(responseJSON)
        }
        return companies
    }

    fun getRepresentatives(): List<Representative> {
        var representatives = listOf<Representative>()

        val request = Request.Builder()
                .url(apiProperties.representativesEndpoint)
                .build()
        var responseJSON: JSONArray

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            responseJSON = JSONArray(response.body!!.string())

            representatives = parseRepresentatives(responseJSON)
        }
        return representatives
    }
}