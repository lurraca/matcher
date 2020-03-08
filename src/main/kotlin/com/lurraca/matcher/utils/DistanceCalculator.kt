package com.lurraca.matcher.utils

    fun distanceInKM(source: GeoPoint, destination: GeoPoint): Double {
        val earthRadiusInKm = 6372.797

        val dLat = Math.toRadians(destination.latitude - source.latitude)
        val dLon = Math.toRadians(destination.longitude - source.longitude)

        val sourceLatRad = Math.toRadians(source.latitude)
        val destinationLatRad = Math.toRadians(destination.latitude)

        val  sqrHalfChordLength= Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(sourceLatRad) * Math.cos(destinationLatRad) *
                Math.sin(dLon / 2) * Math.sin(dLon / 2)
        val angularDistanceRad = 2 * Math.atan2(Math.sqrt(sqrHalfChordLength), Math.sqrt(1 - sqrHalfChordLength))

        val distanceInKM = earthRadiusInKm * angularDistanceRad

        return Math.round(distanceInKM * 100) / 100.0

    }
