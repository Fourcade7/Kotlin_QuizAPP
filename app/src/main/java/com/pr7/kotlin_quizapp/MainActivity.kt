package com.pr7.kotlin_quizapp

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.pr7.kotlin_quizapp.databinding.ActivityMainBinding
import com.pr7.kotlin_quizapp.model.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    lateinit var colorStateList:ColorStateList
    lateinit var colorStateList2:ColorStateList
    lateinit var colorStateList3:ColorStateList
    var trueanswer = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this@MainActivity).get(MainViewModel::class.java)

        colorStateList = ColorStateList(
            arrayOf(
                intArrayOf(android.R.attr.state_enabled),
                ),
                intArrayOf(
                    Color.GREEN,

                )
        )
        colorStateList2 = ColorStateList(
            arrayOf(
                intArrayOf(android.R.attr.state_enabled),
            ),
            intArrayOf(
                Color.RED,

                )
        )
        colorStateList3 = ColorStateList(
            arrayOf(
                intArrayOf(android.R.attr.state_enabled),
            ),
            intArrayOf(
                Color.BLACK,

                )
        )
        binding.radiogroup1.setOnCheckedChangeListener { radioGroup, i ->

            when (i) {
                R.id.radiobutton1 -> {
                    if (trueanswer == binding.radiobutton1.text.toString().toInt()) {
                        binding.radiobutton1.setTextColor(Color.GREEN)
                        binding.radiobutton1.buttonTintList=colorStateList
                        Toast.makeText(this@MainActivity, "True", Toast.LENGTH_SHORT).show()
                    }else{
                        binding.radiobutton1.setTextColor(Color.RED)
                        binding.radiobutton1.buttonTintList=colorStateList2

                    }
                }
                R.id.radiobutton2 -> {
                    if (trueanswer == binding.radiobutton2.text.toString().toInt()) {
                        binding.radiobutton2.setTextColor(Color.GREEN)
                        binding.radiobutton2.buttonTintList=colorStateList
                        Toast.makeText(this@MainActivity, "True", Toast.LENGTH_SHORT).show()
                    }else{
                        binding.radiobutton2.setTextColor(Color.RED)
                        binding.radiobutton2.buttonTintList=colorStateList2

                    }
                }
                R.id.radiobutton3 -> {
                    if (trueanswer == binding.radiobutton3.text.toString().toInt()) {
                        binding.radiobutton3.setTextColor(Color.GREEN)
                        binding.radiobutton3.buttonTintList=colorStateList
                        Toast.makeText(this@MainActivity, "True", Toast.LENGTH_SHORT).show()
                    }else{
                        binding.radiobutton3.setTextColor(Color.RED)
                        binding.radiobutton3.buttonTintList=colorStateList2
                    }
                }
            }

        }
        binding.buttonnextquestion.setOnClickListener {
            startQuiz()
        }


    }

    fun startQuiz() {
        startviewchange()
        var question = mainViewModel.showQuestions()
        binding.textviewquestion.text = question.question
        trueanswer = question.answer1
        val arrayanswer = arrayOf(
            question.answer1.toString(),
            question.answer2.toString(),
            question.answer3.toString()
        )
        arrayanswer.shuffle()
        binding.radiobutton1.text = arrayanswer.get(0)
        binding.radiobutton2.text = arrayanswer.get(1)
        binding.radiobutton3.text = arrayanswer.get(2)
        binding.radiogroup1.clearCheck()
        binding.radiobutton1.setTextColor(Color.BLACK)
        binding.radiobutton2.setTextColor(Color.BLACK)
        binding.radiobutton3.setTextColor(Color.BLACK)

        binding.radiobutton1.buttonTintList=colorStateList3
        binding.radiobutton2.buttonTintList=colorStateList3
        binding.radiobutton3.buttonTintList=colorStateList3


    }

    fun startviewchange() {
        binding.radiogroup1.visibility = View.VISIBLE
        binding.textviewquestion.visibility = View.VISIBLE
        binding.buttonnextquestion.text = "Next"
    }

}