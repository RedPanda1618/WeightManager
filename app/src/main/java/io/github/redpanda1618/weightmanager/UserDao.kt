package io.github.redpanda1618.weightmanager

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table")
    fun getAll(): Flowable<List<User>>

    @Insert
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("DELETE FROM user_table")
    suspend fun clear()

    @Query("SELECT * FROM user_table WHERE id = :key")
    suspend fun get(key: Long): User?


}