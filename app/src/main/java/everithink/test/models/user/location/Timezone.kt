package everithink.test.models.user.location

import android.os.Parcel
import android.os.Parcelable

class Timezone() : Parcelable  {

    lateinit var offset: String
    lateinit var description: String

    constructor(parcel: Parcel) : this() {
        offset = parcel.readString()!!
        description = parcel.readString()!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(offset)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Timezone> {
        override fun createFromParcel(parcel: Parcel): Timezone {
            return Timezone(parcel)
        }

        override fun newArray(size: Int): Array<Timezone?> {
            return arrayOfNulls(size)
        }
    }

}