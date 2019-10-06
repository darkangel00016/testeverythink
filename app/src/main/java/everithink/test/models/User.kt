package everithink.test.models

import android.os.Parcel
import android.os.Parcelable
import everithink.test.models.user.*

class User() : Parcelable {

    lateinit var gender: String
    lateinit var name: name
    lateinit var location: Location
    lateinit var email: String
    lateinit var login: Login
    lateinit var dob: Dob
    lateinit var registered: Registered
    lateinit var phone: String
    lateinit var cell: String
    lateinit var id: Id
    lateinit var picture: Picture
    lateinit var nat: String

    constructor(parcel: Parcel) : this() {
        gender = parcel.readString()
        name = parcel.readParcelable(everithink.test.models.user.name::class.java.classLoader)
        location = parcel.readParcelable(Location::class.java.classLoader)
        email = parcel.readString()
        login = parcel.readParcelable(Login::class.java.classLoader)
        dob = parcel.readParcelable(Dob::class.java.classLoader)
        registered = parcel.readParcelable(Registered::class.java.classLoader)
        phone = parcel.readString()
        cell = parcel.readString()
        id = parcel.readParcelable(Id::class.java.classLoader)
        picture = parcel.readParcelable(Picture::class.java.classLoader)
        nat = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(gender)
        parcel.writeParcelable(name, flags)
        parcel.writeParcelable(location, flags)
        parcel.writeString(email)
        parcel.writeParcelable(login, flags)
        parcel.writeParcelable(dob, flags)
        parcel.writeParcelable(registered, flags)
        parcel.writeString(phone)
        parcel.writeString(cell)
        parcel.writeParcelable(id, flags)
        parcel.writeParcelable(picture, flags)
        parcel.writeString(nat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

}