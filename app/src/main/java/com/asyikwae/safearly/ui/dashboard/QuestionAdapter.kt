package com.asyikwae.safearly.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asyikwae.safearly.databinding.ActivityItemSheetBinding

class QuestionAdapter : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    private val questions = ArrayList<String>()

    fun setData(list: List<String>) {
        questions.clear()
        questions.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionAdapter.ViewHolder {
        return ViewHolder(
            ActivityItemSheetBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: QuestionAdapter.ViewHolder, position: Int) {
        holder.bind(questions[position])
    }

    override fun getItemCount(): Int = questions.size

    class ViewHolder(private val binding: ActivityItemSheetBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(question: String) {
            binding.tvQuestion.text = question
        }
    }
}