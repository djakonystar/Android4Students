package uz.texnopos.android4students

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DividerItemDecoration
import uz.texnopos.android4students.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = StudentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val studentDb = StudentDatabase.getInstance(this)
        val dao = studentDb.getStudentDao()

        adapter.models = dao.getAllStudents()

        binding.apply {
            recyclerView.adapter = adapter
            recyclerView.addItemDecoration(
                DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
            )

            etSearch.addTextChangedListener {
                val text = it.toString()
                val searchValue = "%$text%"
                adapter.models = dao.searchStudents(searchValue)
            }
        }
    }
}
