package uz.texnopos.android4students

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {
    companion object {
        private var INSTANCE: StudentDatabase? = null

        fun getInstance(context: Context): StudentDatabase {
            INSTANCE?.let {
                return it
            }

            val db = Room.databaseBuilder(
                context, StudentDatabase::class.java, "android4.db"
            )
                .createFromAsset("android4.db")
                .allowMainThreadQueries()
                .build()

            INSTANCE = db
            return db
        }
    }

    abstract fun getStudentDao(): StudentDao
}
