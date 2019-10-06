package everithink.test.models.user

import android.os.Parcel
import android.os.Parcelable

class Login() : Parcelable  {

    lateinit var uuid: String
    lateinit var username: String
    lateinit var password: String
    lateinit var salt: String
    lateinit var md5: String
    lateinit var sha1: String
    lateinit var sha256: String

    constructor(parcel: Parcel) : this() {
        uuid = parcel.readString()
        username = parcel.readString()
        password = parcel.readString()
        salt = parcel.readString()
        md5 = parcel.readString()
        sha1 = parcel.readString()
        sha256 = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(uuid)
        parcel.writeString(username)
        parcel.writeString(password)
        parcel.writeString(salt)
        parcel.writeString(md5)
        parcel.writeString(sha1)
        parcel.writeString(sha256)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Login> {
        override fun createFromParcel(parcel: Parcel): Login {
            return Login(parcel)
        }

        override fun newArray(size: Int): Array<Login?> {
            return arrayOfNulls(size)
        }
    }

}