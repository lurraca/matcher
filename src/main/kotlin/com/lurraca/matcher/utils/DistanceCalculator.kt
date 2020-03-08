package com.lurraca.matcher.utils

import kotlin.math.*

fun distanceInKM(source: GeoPoint, destination: GeoPoint): Double {
        val earthRadiusInKm = 6372.797

        val dLat = Math.toRadians(destination.latitude - source.latitude)
        val dLon = Math.toRadians(destination.longitude - source.longitude)

        val sourceLatRad = Math.toRadians(source.latitude)
        val destinationLatRad = Math.toRadians(destination.latitude)

        val  sqrHalfChordLength= sin(dLat / 2) * sin(dLat / 2) +
                cos(sourceLatRad) * cos(destinationLatRad) *
                sin(dLon / 2) * sin(dLon / 2)
        val angularDistanceRad = 2 * atan2(sqrt(sqrHalfChordLength), sqrt(1 - sqrHalfChordLength))

        val distanceInKM = earthRadiusInKm * angularDistanceRad

        return (distanceInKM * 100).roundToInt() / 100.0

    }
