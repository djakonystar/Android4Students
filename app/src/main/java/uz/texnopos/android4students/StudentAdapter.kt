package uz.texnopos.android4students

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.texnopos.android4students.databinding.ItemStudentBinding

class StudentAdapter: RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    inner class StudentViewHolder(private val binding: ItemStudentBinding): ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(student: Student) {
            binding.apply {
                tvName.text = "${student.name} ${student.surname}"
            }
        }
    }

    var models = listOf<Student>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = models.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        val binding = ItemStudentBinding.bind(v)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(models[position])
    }
}
