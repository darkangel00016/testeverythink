package everithink.test.models.user.location

import android.os.Parcel
import android.os.Parcelable

class Coordinates() : Parcelable {

    lateinit var latitude: String
    lateinit var longitude: String

    constructor(parcel: Parcel) : this() {
        latitude = parcel.readString()!!
        longitude = parcel.readString()!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(latitude)
        parcel.writeString(longitude)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Coordinates> {
        override fun createFromParcel(parcel: Parcel): Coordinates {
            return Coordinates(parcel)
        }

        override fun newArray(size: Int): Array<Coordinates?> {
            return arrayOfNulls(size)
        }
    }

}