package everithink.test.models.user

import android.os.Parcel
import android.os.Parcelable

class Dob() : Parcelable  {

    lateinit var date: String
    var age: Int = 0

    constructor(parcel: Parcel) : this() {
        date = parcel.readString()!!
        age = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(date)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dob> {
        override fun createFromParcel(parcel: Parcel): Dob {
            return Dob(parcel)
        }

        override fun newArray(size: Int): Array<Dob?> {
            return arrayOfNulls(size)
        }
    }

}