package uz.texnopos.android4students

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    val surname: String,
    @ColumnInfo(name = "is_favorite") val fav: Int
)
