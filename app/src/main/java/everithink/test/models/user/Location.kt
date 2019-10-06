package everithink.test.models.user

import android.os.Parcel
import android.os.Parcelable
import everithink.test.models.user.location.Coordinates
import everithink.test.models.user.location.Street
import everithink.test.models.user.location.Timezone

class Location() : Parcelable {

    lateinit var street: Street
    lateinit var city: String
    lateinit var state: String
    lateinit var country: String
    lateinit var postcode: String
    lateinit var coordinates: Coordinates
    lateinit var timezone: Timezone

    constructor(parcel: Parcel) : this() {
        street = parcel.readParcelable(Street::class.java.classLoader)
        city = parcel.readString()
        state = parcel.readString()
        country = parcel.readString()
        postcode = parcel.readString()
        coordinates = parcel.readParcelable(Coordinates::class.java.classLoader)
        timezone = parcel.readParcelable(Timezone::class.java.classLoader)
    }

    fun getAddress (): String {
        return "${street.getStreet()} ${city}, ${state} ${postcode}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(street, flags)
        parcel.writeString(city)
        parcel.writeString(state)
        parcel.writeString(country)
        parcel.writeString(postcode)
        parcel.writeParcelable(coordinates, flags)
        parcel.writeParcelable(timezone, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Location> {
        override fun createFromParcel(parcel: Parcel): Location {
            return Location(parcel)
        }

        override fun newArray(size: Int): Array<Location?> {
            return arrayOfNulls(size)
        }
    }

}