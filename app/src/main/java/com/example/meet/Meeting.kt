package com.example.meet

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meetings")
data class Meeting(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val scheduledDate: String
)
