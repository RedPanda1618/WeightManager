package io.github.redpanda1618.weightmanager

import android.content.Context

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserRoomDataBase : RoomDatabase {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserRoomDataBase? = null
        fun getDatabase(context: Context): UserRoomDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserRoomDatabase::class.java,
                    "user_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }

    }
}