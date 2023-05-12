package com.example.adv160420122uts.model

import androidx.room.Entity

@Entity
data class Doctor(
    val id:String?,
    val name:String?,
    val type:String?,
    val experience:Int?,
    val like:Int?,
    val photoUrl:String?,
    val jadwal:String?
)

@Entity
data class Medicine(
    val id:String?,
    val name:String?,
    val quantity:String?,
    val price:String?,
    val description:String?,
    val photoUrl:String?
)

@Entity
data class Profile(
    val id:Int?,
    val name:String?,
    val noTelp:String?
)

@Entity
data class RiwayatTransaksi(
    val id:String?,
    val name:String?,
    val quantity:String?,
    val price:String?,
    val description:String?,
    val photoUrl:String?
)

@Entity
data class Artikel(
    val id:String?,
    val judul:String?,
    val isi:String?,
    val photoUrl: String?
)

@Entity
data class User(
    val id:String?,
    val username:String?,
    val email:String?,
    val password:String?
)