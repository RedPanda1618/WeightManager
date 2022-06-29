package io.github.redpanda1618.weightmanager

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "date")
    val name: String,

    @ColumnInfo(name = "weight")
    val age: Float,

    @ColumnInfo(name = "muscle_rate")
    val muscle_rate: Float,

    @ColumnInfo(name = "fat_rate")
    val fat_rate: Float
    )