package com.example.calculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private var sum = 0f
    private var sumOne = 1f

    private var isPlus = false
    private var isMinis = false
    private var isMulti = false
    private var isDiv = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

    }

    fun operationFunction(view: View) {

        when (view) {

            binding.btnOne -> numberSelected("1")
            binding.btnTwo -> numberSelected("2")
            binding.btnThree -> numberSelected("3")
            binding.btnFour -> numberSelected("4")
            binding.btnFive -> numberSelected("5")
            binding.btnSix -> numberSelected("6")
            binding.btnSeven -> numberSelected("7")
            binding.btnEight -> numberSelected("8")
            binding.btnNine -> numberSelected("9")
            binding.btnZero -> numberSelected("0")
            binding.btnDot -> numberSelected(".")

            binding.btnReset -> restFun()

            binding.btnPlus -> {
                try {
                    sum += binding.editTxtText.text.toString().toFloat()
                    binding.editTxtText.setText(R.string.enter_sec_value)
                    isPlus = true
                } catch (e: NumberFormatException) {
                    binding.editTxtText.setText(R.string.enter_number)
                }

            }
            binding.btnMinis -> {
                try {
                    sum = binding.editTxtText.text.toString().toFloat() - sum
                    binding.editTxtText.setText(R.string.enter_sec_value)
                    isMinis = true
                } catch (e: NumberFormatException) {
                    binding.editTxtText.setText(R.string.enter_number)
                }
            }
            binding.btnMulti -> {
                try {
                    sumOne *= binding.editTxtText.text.toString().toFloat()
                    binding.editTxtText.setText(R.string.enter_sec_value)
                    isMulti = true
                } catch (e: NumberFormatException) {
                    binding.editTxtText.setText(R.string.enter_number)
                }
            }
            binding.btnDiv -> {
                try {
                    sumOne = binding.editTxtText.text.toString().toFloat() / sumOne
                    binding.editTxtText.setText(R.string.enter_sec_value)
                    isDiv = true
                } catch (e: NumberFormatException) {
                    binding.editTxtText.setText(R.string.enter_number)
                }
            }
            binding.btnEqual -> {
                when {
                    isPlus -> {
                        try {
                            val number2 = binding.editTxtText.text.toString().toFloat()
                            sum += number2
                            binding.editTxtText.setText(sum.toString())
                            isPlus = false
                            sum = 0f
                        } catch (e: NumberFormatException) {
                            binding.editTxtText.setText(R.string.enter_number)
                        }
                    }
                    isMinis -> {
                        try {
                            val number2 = binding.editTxtText.text.toString().toFloat()
                            sum -= number2
                            binding.editTxtText.setText(sum.toString())
                            isMinis = false
                            sum = 0f
                        } catch (e: NumberFormatException) {
                            binding.editTxtText.setText(R.string.enter_number)
                        }
                    }
                    isMulti -> {
                        try {
                            val number2 = binding.editTxtText.text.toString().toFloat()
                            sumOne *= number2
                            binding.editTxtText.setText(sumOne.toString())
                            isMulti = false
                            sumOne = 1f
                        } catch (e: NumberFormatException) {
                            binding.editTxtText.setText(R.string.enter_number)
                        }
                    }
                    isDiv -> {
                        try {
                            val number2 = binding.editTxtText.text.toString().toFloat()
                            sumOne /= number2
                            binding.editTxtText.setText(sumOne.toString())
                            isDiv = false
                            sumOne = 1f
                        } catch (e: NumberFormatException) {
                            binding.editTxtText.setText(R.string.enter_number)
                        }
                    }
                }
            }


        }

    }

    private fun numberSelected(numberSelected: String) {

        if (binding.editTxtText.text.toString() == "Please Enter your Second value" || binding.editTxtText.text.toString() == "Enter Number") {
            binding.editTxtText.setText(numberSelected)
        } else {
            val number = binding.editTxtText.text.toString() + numberSelected
            binding.editTxtText.setText(number)
        }

    }

    private fun restFun() {
        binding.editTxtText.setText("")
        sum = 0f
        sumOne = 1f
    }
}
