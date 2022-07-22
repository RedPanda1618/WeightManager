package io.github.redpanda1618.weightmanager

import androidx.room.*
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM user_table LIMIT :size")
    fun get(size: Int): List<User>

    @Query("SELECT COUNT(*) FROM user_table")
    fun size(): Int

    @Query("DELETE FROM user_table")
    fun deleteAll()

    @Query("SELECT * FROM user_table")
    fun getAll(): List<User>
}