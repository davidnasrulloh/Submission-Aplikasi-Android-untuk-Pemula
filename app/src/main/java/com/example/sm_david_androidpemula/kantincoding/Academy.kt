package com.example.sm_david_androidpemula.kantincoding

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class Academy(
    var name: String? = "",
    var rate: String? = "",
    var photo: String? = "",
    var overview: String? = "",
    var detail: String? = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    companion object : Parceler<Academy> {

        override fun Academy.write(parcel: Parcel, flags: Int) {
            parcel.writeString(name)
            parcel.writeString(rate)
            parcel.writeString(photo)
            parcel.writeString(overview)
            parcel.writeString(detail)
        }

        override fun create(parcel: Parcel): Academy {
            return Academy(parcel)
        }
    }
}
