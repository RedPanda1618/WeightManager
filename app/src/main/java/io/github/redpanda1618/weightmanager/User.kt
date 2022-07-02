package io.github.redpanda1618.weightmanager

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "weight")
    val age: Float,

    @ColumnInfo(name = "muscle")
    val muscle: Float,

    @ColumnInfo(name = "fat")
    val fat: Float
    )