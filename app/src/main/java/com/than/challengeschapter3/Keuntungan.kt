package com.than.challengeschapter3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Keuntungan(
    var hargaPerDus: Int,
    var piecePerDus: Int,
    var hargaJualPerPiece: Int
) : Parcelable
