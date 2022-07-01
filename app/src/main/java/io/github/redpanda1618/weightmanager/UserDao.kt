package io.github.redpanda1618.weightmanager

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table")
    suspend fun getAll(): List<User>

    @Insert
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("DELETE FROM user_table")
    suspend fun clear()

    @Query("SELECT * FROM user_table WHERE id = :key")
    suspend fun get(key: Long): User

    @Query("SELECT weight FROM user_table LIMIT :size")
    suspend fun getWeight(size: Int): List<Float>

    @Query("SELECT muscle FROM user_table LIMIT :size")
    suspend fun getMuscle(size: Int): List<Float>

    @Query("SELECT fat FROM user_table LIMIT :size")
    suspend fun getFat(size: Int): List<Float>

    @Query("SELECT date FROM user_table LIMIT :size")
    suspend fun getDate(size: Int): List<Long>

    @Query("SELECT COUNT(*) FROM user_table")
    fun getSize(): Int
}