package com.example.tp3_fickleflight_grupo7.entities

import android.os.Parcel
import android.os.Parcelable

class Flight (departure_airport: Airport?, arrival_airport: Airport?, duration: String?, airplane: String?, airline: String?, logo : String?, travel_class: String?,
    flight_number: String?, legroom: String?, extensions: List<String>): Parcelable {


    var departure_airport: Airport?
    var arrival_airport: Airport?
    var duration: String?
    var airplane: String?
    var airline: String?
    var logo: String?
    var travel_class: String?
    var flight_number: String?
    var legroom: String?
    var extensions: List<String>

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Airport::class.java.classLoader),
        parcel.readParcelable(Airport::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList()!!
    )

    init{
        this.departure_airport = departure_airport
        this.arrival_airport = arrival_airport
        this.duration = duration
        this.airplane = airplane
        this.airline = airline
        this.logo = logo
        this.travel_class = travel_class
        this.flight_number = flight_number
        this.legroom = legroom
        this.extensions = extensions
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(departure_airport, flags)
        parcel.writeParcelable(arrival_airport, flags)
        parcel.writeString(duration)
        parcel.writeString(airplane)
        parcel.writeString(airline)
        parcel.writeString(logo)
        parcel.writeString(travel_class)
        parcel.writeString(flight_number)
        parcel.writeString(legroom)
        parcel.writeStringList(extensions)
    }


    override fun toString(): String {
        return "Flight(departure_airport=$departure_airport, arrival_airport=$arrival_airport, duration='$duration', airplane='$airplane', airline='$airline', logo='$logo', travel_class='$travel_class', flight_number='$flight_number', legroom='$legroom', extensions=$extensions)"
    }


    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Flight> {
        override fun createFromParcel(parcel: Parcel): Flight {
            return Flight(parcel)
        }

        override fun newArray(size: Int): Array<Flight?> {
            return arrayOfNulls(size)
        }
    }



}