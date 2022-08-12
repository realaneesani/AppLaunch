package com.helium4.weatherapp.room

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.math.ln


@Entity(tableName = "UserTable")
class User{

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "userId")
    var id:Int =0

    @ColumnInfo(name = "FName")
    var fname:String =""

    @ColumnInfo(name = "LName")
    var lname:String =""

    @ColumnInfo(name = "Email")
    var email:String =""


    constructor(){}

    constructor(id :Int,fname: String, lname: String, email: String) {
        this.fname = fname
        this.lname = lname
        this.email = email
    }
    constructor(fname: String, lname: String, email: String) {
        this.fname = fname
        this.lname = lname
        this.email = email
    }
}