package com.asyikwae.safearly.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    var uid: String? = "",
    var email: String? = "",
    var name: String? = "",
    var photoUrl: String? = "",
): Parcelable