package com.example.jopsearchapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// 🔹 Job model
// to solve problem of parcelize sould use  id("kotlin-parcelize") in gradle file
@Parcelize
data class Job(
    val title: String,
    val company: String,
    val fullTime: String,
    val remote: String,
    val salary: String,
    val image: Int
) : Parcelable