package com.betulesen.appointmentapp.Model

import android.os.Parcel
import android.os.Parcelable

data class DoctorsModel (
    val Address:String="",
    val Biography:String="",
    val Id:Int=0,
    val Name:String="",
    val Picture:String="",
    val Special:String="",
    val Experiense:Int=0,
    val Cost:String="",
    val Date:String="",
    val Time:String="",
    val Location:String="",
    val Mobile:String="",
    val Patiens:String="",
    val Rating:Double=0.0,
    val site:String=""
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Address)
        parcel.writeString(Biography)
        parcel.writeInt(Id)
        parcel.writeString(Name)
        parcel.writeString(Picture)
        parcel.writeString(Special)
        parcel.writeInt(Experiense)
        parcel.writeString(Cost)
        parcel.writeString(Date)
        parcel.writeString(Time)
        parcel.writeString(Location)
        parcel.writeString(Mobile)
        parcel.writeString(Patiens)
        parcel.writeDouble(Rating)
        parcel.writeString(site)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DoctorsModel> {
        override fun createFromParcel(parcel: Parcel): DoctorsModel {
            return DoctorsModel(parcel)
        }

        override fun newArray(size: Int): Array<DoctorsModel?> {
            return arrayOfNulls(size)
        }
    }
}
