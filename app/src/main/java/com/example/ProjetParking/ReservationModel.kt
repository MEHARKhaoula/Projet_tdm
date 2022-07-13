package com.example.ProjetParking

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName ="reservation", foreignKeys = [ForeignKey(entity= UserModel::class,
    parentColumns=["iduser"] ,childColumns = ["iduser"],
    onUpdate = ForeignKey.CASCADE,
    onDelete = ForeignKey.CASCADE ),ForeignKey(entity=PlaceModel::class,
    parentColumns=["idplace"] ,childColumns = ["idplace"],
    onUpdate = ForeignKey.CASCADE,
    onDelete = ForeignKey.CASCADE )])

data class ReservationModel(

    @PrimaryKey
    val numeroreservation:Int,
    val date: String,
    val heure_entree: String,
    val heure_sortie: String,
    val iduser:Int,
    val idplace:Int


)
