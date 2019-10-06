package everithink.test.models.user.location

import android.os.Parcel
import android.os.Parcelable

class Street() : Parcelable {

    var number: String = ""
    var name: String = ""

    constructor(parcel: Parcel) : this() {
        number = parcel.readString()!!
        name = parcel.readString()!!
    }

    fun getStreet (): String {
        return "${number} ${name}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(number)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Street> {
        override fun createFromParcel(parcel: Parcel): Street {
            return Street(parcel)
        }

        override fun newArray(size: Int): Array<Street?> {
            return arrayOfNulls(size)
        }
    }

}