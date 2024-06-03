package com.example.tp3_fickleflight_grupo7.entities

import android.os.Parcel
import android.os.Parcelable

class Airport(airport_id: String?, airport_name: String?, time:String?): Parcelable {
    var airport_id: String?
    var airport_name: String?
    var time: String?

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    init{
        this.airport_id = airport_id
        this.airport_name = airport_name
        this.time = time
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(airport_id)
        parcel.writeString(airport_name)
        parcel.writeString(time)
    }


    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Airport> {
        override fun createFromParcel(parcel: Parcel): Airport {
            return Airport(parcel)
        }

        override fun newArray(size: Int): Array<Airport?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "Airport(airport_id='$airport_id', airport_name='$airport_name', time='$time')"
    }
}
