package io.github.redpanda1618.weightmanager

import androidx.room.*
import io.reactivex.Flowable

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM user_table LIMIT :size")
    fun get(size: Int): Flowable<List<User>>?
}