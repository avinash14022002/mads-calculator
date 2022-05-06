package com.example.madscalucator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.madscalucator.databinding.HistoryLayoutBinding

class HistoryActivity : AppCompatActivity() {
    private var historyList = arrayListOf<HistoryData>()
    private lateinit var binding: HistoryLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HistoryLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        historyList = CalculatorActivity.history
        if (historyList.isNotEmpty()) {
            historyList.forEach {
                binding.historyText.append(it.value + "\n")
                binding.historyText.append("Ans: " + it.result + "\n\n\n")
            }
        } else {
            binding.historyText.text = "No History Available"
        }
    }

}