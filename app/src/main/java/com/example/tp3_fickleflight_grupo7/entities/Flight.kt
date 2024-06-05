package com.example.tp3_fickleflight_grupo7.entities

import android.os.Parcel
import android.os.Parcelable

class Flight (departure_airport: Airport?,
              arrival_airport: Airport?,
              duration: Int?,
              airplane: String?,
              airline: String?,
              airline_logo : String?,
              travel_class: String?,
              flight_number: String?,
              legroom: String?,
              extensions: List<String>,
            overnight: Boolean?)
                : Parcelable {


    var departure_airport: Airport?
    var arrival_airport: Airport?
    var duration: Int?
    var airplane: String?
    var airline: String?
    var airline_logo: String?
    var travel_class: String?
    var flight_number: String?
    var legroom: String?
    var extensions: List<String>
    var overnight: Boolean?

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Airport::class.java.classLoader),
        parcel.readParcelable(Airport::class.java.classLoader),
        parcel.readValue(Int::class.java.classLoader) as Int?,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList()!!,
        parcel.readValue(Boolean::class.java.classLoader) as Boolean?
    )

    init{
        this.departure_airport = departure_airport
        this.arrival_airport = arrival_airport
        this.duration = duration
        this.airplane = airplane
        this.airline = airline
        this.airline_logo = airline_logo
        this.travel_class = travel_class
        this.flight_number = flight_number
        this.legroom = legroom
        this.extensions = extensions
        this.overnight = overnight
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(departure_airport, flags)
        parcel.writeParcelable(arrival_airport, flags)
        parcel.writeInt(duration!!)
        parcel.writeString(airplane)
        parcel.writeString(airline)
        parcel.writeString(airline_logo)
        parcel.writeString(travel_class)
        parcel.writeString(flight_number)
        parcel.writeString(legroom)
        parcel.writeStringList(extensions)
        parcel.writeValue(overnight)
    }


    override fun toString(): String {
        return "Flight(departure_airport=$departure_airport, arrival_airport=$arrival_airport, duration='$duration', airplane='$airplane', airline='$airline', logo='$airline_logo', travel_class='$travel_class', flight_number='$flight_number', legroom='$legroom', extensions=$extensions)"
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