package everithink.test.models.user

import android.os.Parcel
import android.os.Parcelable

class name() : Parcelable {

    lateinit var title: String
    lateinit var first: String
    lateinit var last: String

    constructor(parcel: Parcel) : this() {
        title = parcel.readString()
        first = parcel.readString()
        last = parcel.readString()
    }

    fun getName(): String {
        return "${title} ${first} ${last}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(first)
        parcel.writeString(last)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<name> {
        override fun createFromParcel(parcel: Parcel): name {
            return name(parcel)
        }

        override fun newArray(size: Int): Array<name?> {
            return arrayOfNulls(size)
        }
    }

}