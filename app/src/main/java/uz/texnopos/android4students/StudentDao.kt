package uz.texnopos.android4students

import androidx.room.Dao
import androidx.room.Query

@Dao
interface StudentDao {
    @Query("SELECT * FROM students")
    fun getAllStudents(): List<Student>

    @Query("SELECT * FROM students WHERE name like :searchValue")
    fun searchStudents(searchValue: String): List<Student>
}
