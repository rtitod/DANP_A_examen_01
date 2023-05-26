package com.example.examen1.database.model
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.examen1.database.entities.User

@Database(
    entities = [User::class],
    version = 6
)
abstract class MyAppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: MyAppDatabase? = null

        fun getInstance(context: Context): MyAppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyAppDatabase::class.java,
                        "database"
                    ).allowMainThreadQueries().build()

                    INSTANCE = instance

                }

                return instance
            }
        }
    }
}