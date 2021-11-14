package com.example.login_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login_kotlin.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            calculateTip()
        }

    }

    private fun calculateTip() {
        val stringintextField = binding.cost.text.toString()
        val cost = stringintextField.toDouble()
        val selectedId = binding.tipOption.checkedRadioButtonId
        val tippercentage = when (selectedId) {
            R.id.radioButton20 -> 0.20
            R.id.radioButton18 -> 0.18
            else -> 0.15
        }
        var tip = tippercentage * cost
        val roundUp = binding.roundUpSwitch.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        val formattip = NumberFormat.getCurrencyInstance().format(tip)
        binding.Result.text = getString(R.string.tip_amount, formattip)
    }


}