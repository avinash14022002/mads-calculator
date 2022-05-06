package com.example.madscalucator.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.madscalucator.R
import com.example.madscalucator.Utils.MADSCalculation
import com.example.madscalucator.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        var history = arrayListOf<HistoryData>()
    }

    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()
        init()
    }

    private fun init() {
        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)
        binding.button6.setOnClickListener(this)
        binding.button7.setOnClickListener(this)
        binding.button8.setOnClickListener(this)
        binding.button9.setOnClickListener(this)
        binding.buttonAdd.setOnClickListener(this)
        binding.buttonSubtraction.setOnClickListener(this)
        binding.buttonMultiply.setOnClickListener(this)
        binding.buttonEqual.setOnClickListener(this)
        binding.buttonDivide.setOnClickListener(this)
        binding.buttonPoint.setOnClickListener(this)
        binding.buttonZero.setOnClickListener(this)
        binding.buttonBack.setOnClickListener(this)
        binding.buttonHistory.setOnClickListener(this)
        binding.buttonclear.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button1 -> {
                evaluateExpression("1", true)
            }
            R.id.button2 -> {
                evaluateExpression("2", true)
            }
            R.id.button3 -> {
                evaluateExpression("3", true)
            }
            R.id.button4 -> {
                evaluateExpression("4", true)
            }
            R.id.button5 -> {
                evaluateExpression("5", true)
            }
            R.id.button6 -> {
                evaluateExpression("6", true)
            }
            R.id.button7 -> {
                evaluateExpression("7", true)
            }
            R.id.button8 -> {
                evaluateExpression("8", true)
            }
            R.id.button9 -> {
                evaluateExpression("9", true)
            }
            R.id.buttonZero -> {
                evaluateExpression("0", true)
            }
            R.id.buttonAdd -> {
                evaluateExpression("+", true)
            }
            R.id.buttonDivide -> {
                evaluateExpression("/", true)
            }
            R.id.buttonEqual -> {
                try {
                    val result = MADSCalculation(binding.textView1.text.toString())
                    binding.textResult.text = result.toString()
                    saveToPref(binding.textView1.text.toString(), result)
                } catch (e: Exception) {
                    Log.d("Exception", " message : " + e.message)
                }
            }
            R.id.buttonMultiply -> {
                evaluateExpression("*", true)
            }
            R.id.buttonSubtraction -> {
                evaluateExpression("-", true)
            }
            R.id.buttonPoint -> {
                evaluateExpression(".", true)
            }
            R.id.buttonBack -> {
                val text = binding.textView1.text.toString()
                if (text.isNotEmpty()) {
                    binding.textView1.text = text.substring(0, binding.textView1.text.length - 1)
                }
                binding.textResult.text = ""
            }
            R.id.buttonclear -> {
                binding.textView1.text = ""
                binding.textResult.text = ""
            }
            R.id.buttonHistory -> {
                startActivity(Intent(this, HistoryActivity()::class.java).putExtra("List", history))
            }
        }
    }

    private fun saveToPref(toString: String, result: Double) {
        if (history.size <= 10) {
            val historyData = HistoryData()
            historyData.value = toString
            historyData.result = result.toString()
            history.add(historyData)
        }
    }


    private fun evaluateExpression(string: String, clear: Boolean) {
        if (clear) {
            binding.textResult.text = ""
            binding.textView1.append(string)
        } else {
            binding.textView1.append(binding.textResult.text)
            binding.textView1.append(string)
            binding.textResult.text = ""
        }
    }
}