package com.than.challengeschapter3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Biodata(
    var nama : String,
    var usia : Int,
    var alamat : String,
    var pekerjaan : String
) : Parcelable
