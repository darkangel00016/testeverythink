package everithink.test.models.user

import android.os.Parcel
import android.os.Parcelable

class Id() : Parcelable {

    lateinit var name: String
    lateinit var value: String

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()!!
        value = parcel.readString()!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(value)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Id> {
        override fun createFromParcel(parcel: Parcel): Id {
            return Id(parcel)
        }

        override fun newArray(size: Int): Array<Id?> {
            return arrayOfNulls(size)
        }
    }

}