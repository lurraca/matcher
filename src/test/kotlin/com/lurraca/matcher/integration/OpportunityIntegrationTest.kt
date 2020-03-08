package com.lurraca.matcher.integration

import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class OpportunityIntegrationTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate;

    @Test
    fun `It should return a list of opportunities`() {
        val response = testRestTemplate.getForEntity("/api/v1/opportunities", String::class.java)
        assertNotNull(response)
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(testJson(), response.body)
    }

    @Test
    fun `It should return a HTML listing opportunities`() {
        val response = testRestTemplate.getForEntity("/", String::class.java)
        assertNotNull(response)
        assertEquals(HttpStatus.OK, response.statusCode)
        assertThat(response.body, containsString("List of Opportunities"))
        assertThat(response.body, containsString("The representative"))
        assertThat(response.body, containsString("Rep 11"))
    }

    fun testJson() =
            "[{\"representative\":{\"name\":\"Rep 8\",\"email\":\"rep8@salesforce.com\",\"phone\":\"00000008\"},\"company\":{\"name\":\"LABORATORY CORP. OF AMERICA\",\"address\":\"358 SOUTH MAIN STREET\",\"contact\":{\"name\":\"Rappaport Irene\",\"email\":\"IreneDRappaport@teleworm.us\",\"phone\":\"(08) 9077 5800\"}}},{\"representative\":{\"name\":\"Rep 9\",\"email\":\"rep9@salesforce.com\",\"phone\":\"00000009\"},\"company\":{\"name\":\"LAM RESEARCH\",\"address\":\"4650 CUSHING PARKWAY\",\"contact\":{\"name\":\"McGrath Herbert\",\"email\":\"HerbertAMcGrath@dayrep.com\",\"phone\":\"(08) 8301 6403\"}}},{\"representative\":{\"name\":\"Rep 11\",\"email\":\"rep11@salesforce.com\",\"phone\":\"00000011\"},\"company\":{\"name\":\"SYNNEX\",\"address\":\"44201 NOBEL DRIVE\",\"contact\":{\"name\":\"Mullins Janae\",\"email\":\"JanaeEMullins@superrito.com\",\"phone\":\"(02) 6735 4431\"}}},{\"representative\":{\"name\":\"Rep 12\",\"email\":\"rep12@salesforce.com\",\"phone\":\"00000012\"},\"company\":{\"name\":\"ROSS STORES\",\"address\":\"5130 HACIENDA DRIVE\",\"contact\":{\"name\":\"Artiaga Michael\",\"email\":\"MichaelEArtiaga@superrito.com\",\"phone\":\"(02) 6710 1234\"}}},{\"representative\":{\"name\":\"Rep 13\",\"email\":\"rep13@salesforce.com\",\"phone\":\"00000013\"},\"company\":{\"name\":\"CLOROX\",\"address\":\"1221 BROADWAY\",\"contact\":{\"name\":\"Delany William\",\"email\":\"WilliamJDelany@dayrep.com\",\"phone\":\"(07) 4072 2883\"}}},{\"representative\":{\"name\":\"Rep 29\",\"email\":\"rep29@salesforce.com\",\"phone\":\"00000029\"},\"company\":{\"name\":\"ARROW ELECTRONICS\",\"address\":\"9201 EAST DRY CREEK ROAD\",\"contact\":{\"name\":\"Murphy Stephanie\",\"email\":\"StephanieLMurphy@teleworm.us\",\"phone\":\"(07) 3938 4539\"}}},{\"representative\":{\"name\":\"Rep 30\",\"email\":\"rep30@salesforce.com\",\"phone\":\"00000030\"},\"company\":{\"name\":\"NEWMONT MINING\",\"address\":\"6363 SOUTH FIDDLER'S GREEN CIRCLE\",\"contact\":{\"name\":\"Nickens Rebecca\",\"email\":\"RebeccaWNickens@fleckens.hu\",\"phone\":\"(08) 8308 5185\"}}},{\"representative\":{\"name\":\"Rep 22\",\"email\":\"rep22@salesforce.com\",\"phone\":\"00000022\"},\"company\":{\"name\":\"WESCO INTERNATIONAL\",\"address\":\"225 WEST STATION SQUARE DRIVE\",\"contact\":{\"name\":\"Eakes Vicki\",\"email\":\"VickiCEakes@rhyta.com\",\"phone\":\"(03) 5360 8128\"}}},{\"representative\":{\"name\":\"Rep 23\",\"email\":\"rep23@salesforce.com\",\"phone\":\"00000023\"},\"company\":{\"name\":\"PPG INDUSTRIES\",\"address\":\"1 PPG PLACE\",\"contact\":{\"name\":\"Morton Rachael\",\"email\":\"RachaelRMorton@teleworm.us\",\"phone\":\"(02) 4995 3240\"}}},{\"representative\":{\"name\":\"Rep 24\",\"email\":\"rep24@salesforce.com\",\"phone\":\"00000024\"},\"company\":{\"name\":\"PNC FINANCIAL SERVICES GROUP\",\"address\":\"249 5TH AVENUE\",\"contact\":{\"name\":\"Horn Bessie\",\"email\":\"BessieFHorn@dayrep.com\",\"phone\":\"(07) 5339 2250\"}}},{\"representative\":{\"name\":\"Rep 25\",\"email\":\"rep25@salesforce.com\",\"phone\":\"00000025\"},\"company\":{\"name\":\"UNITED STATES STEEL\",\"address\":\"600 GRANT STREET\",\"contact\":{\"name\":\"Silva Jeana\",\"email\":\"JeanaRSilva@einrot.com\",\"phone\":\"(03) 5306 7759\"}}},{\"representative\":{\"name\":\"Rep 17\",\"email\":\"rep17@salesforce.com\",\"phone\":\"00000017\"},\"company\":{\"name\":\"DICK'S SPORTING GOODS\",\"address\":\"345 COURT STREET\",\"contact\":{\"name\":\"Perkins Toni\",\"email\":\"ToniDPerkins@cuvox.de\",\"phone\":\"(07) 4951 6597\"}}},{\"representative\":{\"name\":\"Rep 27\",\"email\":\"rep27@salesforce.com\",\"phone\":\"00000027\"},\"company\":{\"name\":\"STEEL DYNAMICS\",\"address\":\"7575 WEST JEFFERSON BOULEVARD\",\"contact\":{\"name\":\"Bryant Daniel\",\"email\":\"DanielSBryant@jourrapide.com\",\"phone\":\"(07) 4598 9953\"}}},{\"representative\":{\"name\":\"Rep 4\",\"email\":\"rep4@salesforce.com\",\"phone\":\"00000004\"},\"company\":{\"name\":\"ALBERTSONS COS.\",\"address\":\"250 PARKCENTER BOULEVARD\",\"contact\":{\"name\":\"Daniel Jayne\",\"email\":\"JayneADaniel@jourrapide.com\",\"phone\":\"(07) 4961 5112\"}}},{\"representative\":{\"name\":\"Rep 1\",\"email\":\"rep1@salesforce.com\",\"phone\":\"00000001\"},\"company\":{\"name\":\"MICRON TECHNOLOGY\",\"address\":\"8000 SOUTH FEDERAL WAY\",\"contact\":{\"name\":\"Blanco Julia\",\"email\":\"JuliaMBlanco@superrito.com\",\"phone\":\"(02) 4015 2417\"}}}]"

}