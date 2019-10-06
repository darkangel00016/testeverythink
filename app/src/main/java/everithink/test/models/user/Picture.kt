package everithink.test.models.user

import android.os.Parcel
import android.os.Parcelable

class Picture() : Parcelable  {

    lateinit var large: String
    lateinit var medium: String
    lateinit var thumbnail: String

    constructor(parcel: Parcel) : this() {
        large = parcel.readString()
        medium = parcel.readString()
        thumbnail = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(large)
        parcel.writeString(medium)
        parcel.writeString(thumbnail)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Picture> {
        override fun createFromParcel(parcel: Parcel): Picture {
            return Picture(parcel)
        }

        override fun newArray(size: Int): Array<Picture?> {
            return arrayOfNulls(size)
        }
    }

}