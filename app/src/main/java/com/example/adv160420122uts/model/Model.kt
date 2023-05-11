package com.example.adv160420122uts.model

data class Doctor(
    val id:String?,
    val name:String?,
    val type:String?,
    val experience:Int?,
    val like:Int?,
    val photoUrl:String?,
    val jadwal:String?
)

data class Medicine(
    val id:String?,
    val name:String?,
    val quantity:String?,
    val price:String?,
    val description:String?,
    val photoUrl:String?
)

data class Profile(
    val id:Int?,
    val name:String?,
    val noTelp:String?
)

data class RiwayatTransaksi(
    val id:String?,
    val name:String?,
    val quantity:String?,
    val price:String?,
    val description:String?,
    val photoUrl:String?
)