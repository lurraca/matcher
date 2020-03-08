package com.lurraca.matcher.utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DistanceCalculatorTest {
    @Test
    fun itShouldCalculateDistanceInKmBetween_NorthToSouthIreland() {
        val north = GeoPoint(55.370775, -7.308923)
        val south = GeoPoint(51.476302, -9.370285)
        val distance = distanceInKM(north, south)

        assertEquals(454.15, distance)
    }

    @Test
    fun itShouldCalculateDistanceInKmBetween_NewYorkToLondon() {
        val newYork = GeoPoint(40.730610, -73.935242)
        val london = GeoPoint(	51.509865, -0.118092)
        val distance = distanceInKM(newYork, london)

        assertEquals(5566.45, distance)
    }
}