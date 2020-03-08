This application generates a list of opportunities by matching [companies](http://www.mocky.io/v2/5df8fc57300000d45688a10e) and [representatives](http://www.mocky.io/v2/5df8fc57300000d45688a10e) by distance.

## Business Requirements

* A representative can only visit one company.
* Limit matches to 100KM Distance.
* Always find the closest representative to the company.
* Don't show companies without representative.
* Restful Endpoint: https://sales-opportunities.herokuapp.com/api/v1/opportunities
* HTML View for readability: https://sales-opportunities.herokuapp.com

## My Notes

* I didn't use the language that I am most comfortable with, that would be Ruby. Instead I use Kotlin, which I have used in the past to some degree. There are various reason for this choice:
    * When doing coding assessment I always try to get something out of it for my own growth, rediscovering and learning new things in Kotlin and Spring Boot is a good outcome for me. I love learning.
    * I know that Salesforce is starting to use Kotlin more and more, figured that someone that have to review my project would appreciate the fact that they wouldn't have to go and try to understand code on a language that they never seen before.
    * Always enjoy a good challenge.   

* For the distance calculation I did use the Haversine Formula. I didn't looked around much but I am certain that there should be some libraries that already have the implementation and would had probably been the safest and easiest choice. Instead I went and implemented it myself, wrote a few tests cases for it, feeling confident about. Something to note when dealing with haversine formula is that precision matters, depending of how many decimals positions you are dealing with results can be off by small amount of meters.

* The representatives endpoint returns the geo coordinates as a single property `location` while the companies endpoint have separate properties `LATITIDE` and `LONGITUDE`. I made the assumption around the format of the `location` field to be `latitude, longitude`. On a regular day to day I would definitely double check with the endpoint provider.
### Implementation

* API Versioning. I choose to version the api endpoint `/ap1/v1/`, and the components that are used by the Opportunitiecontroller of the application under a package that names the version. i.e: `v1`. There are many ways of versioning APIs and packaging applications, the optimal solution depends on many factors including the users of the API. I figured this was a place to start and easy to iterate on.
* Static Web HTML (Thymeleaf). I figured that given business requirements it wasn't necessary to bring in anything different. I could have gone with the flavour of the moment super fancy JS frontend framework. But for a very small view, I didn't feel it was necessary. Also defer the decision about what is the best to use for later when there might be more information.
* Rediscovering Spring Dependency Injection was interesting, it works and once you have the handle definitely makes thing easy.
* I really enjoyed Kotlin approach to immutability.
* Kotlin collections operations are very useful. Lots of similarity to the functional programming capabilities of ruby. Used `filter` and `minBy` to implement some of the business logic on the app.
* Dealing with JSON is a little bit more painful than on dynamic typed languages. I used JSONObject and JSONArray implentations. These were enough for an application of this size, but I can see how on a bigger application is not feasible because it adds a lot of boilerplate code when transforming JSON responses to Kotlin objects. I could have used one of the thousands libraries that deserialize JSON into Objects but decided not dig into it now. Again, this can iterated on if the application gets bigger.

### Tests
* **Integration**
    * OpportunityIntegration. Test both endpoints by making a HTTP request, and asserting in the response. Ensure that things are wired together and that the application exposes the right endpoints and respond with the right structure.
* **Unit**
    * Utils. DistanceCalculator. A few cases to test out the implementation of the haversine formula.
    * Services. OpportunityServiceImplTest. Test the business logic of the application. Test cases for the different scenarios and edge cases.

# Cloud Version
This application has been deployed to Heroku for easy access.

- RESTful JSON Endpoint: https://sales-opportunities.herokuapp.com/api/v1/opportunities
- HTML Endpoint: https://sales-opportunities.herokuapp.com

**Note:** The first request takes some time to warm up the application, using the unpaid version of heroku which mean they make the container sleep if it's unused.

# Running locally

## gradlew bootRun

1. Ensure that Java 13 is installed in the system

    ```bash
    $ java --version
    openjdk 13.0.1 2019-10-15
    OpenJDK Runtime Environment (build 13.0.1+9)
    OpenJDK 64-Bit Server VM (build 13.0.1+9, mixed mode, sharing)
    ```

2. Clone the git project or Download as zip

    * (ZIP) 
        * Go to https://github.com/lurraca/matcher
        * Click on "Clone or Download" -> Download as ZIP
        * Unzip the file and navigate to the resulting directory on the terminal
    * (Git Clone)
        * From the terminal:
        * ```$ git clone https://github.com/lurraca/matcher.git```
    * ```cd matcher```
  
3. ```./gradlew bootRun```
    * This will start the application on `localhost` running on port 8080.
    * Once the application is running query the endpoints:
      * JSON Endpoint: http://localhost:8080/api/v1/opportunities
      * HTML View: http://localhost:8080

# Running tests

## gradlew clean test

1. Ensure that Java 13 is installed in the system
    ```bash
    $ java --version
    openjdk 13.0.1 2019-10-15
    OpenJDK Runtime Environment (build 13.0.1+9)
    OpenJDK 64-Bit Server VM (build 13.0.1+9, mixed mode, sharing)
    ```

2. Clone the git project or Download as zip
    * (ZIP) 
        * Go to https://github.com/lurraca/matcher
        * Click on "Clone or Download" -> Download as ZIP
        * Unzip the file and navigate to the resulting directory on the terminal
    * (Git Clone)
        * From the terminal:
        * ```$ git clone https://github.com/lurraca/matcher.git```
    * ```cd matcher```
    
 3. ```$ gradlew clean test```
    
    *  Test will run and a summary will be displayed on the terminal.
    
 # Dependencies
 * Java/Kotlin
 * Spring Boot 2.2.5
 * OKHTTP (HTTP Requests)
 * JSON (org.json)
 