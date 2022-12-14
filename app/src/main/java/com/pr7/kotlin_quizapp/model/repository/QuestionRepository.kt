package com.pr7.kotlin_quizapp.model.repository

import com.pr7.kotlin_quizapp.model.questionmodel.Question

class QuestionRepository {

    fun getAllQuestion():Array<Question>{
        val questionarray= arrayOf<Question>(
            Question(question = "16+73", answer1 = 89, answer2 = 83, answer3 = 91),
            Question(question = "10+27", answer1 = 37, answer2 = 36, answer3 = 42),
            Question(question = "25+45", answer1 = 70, answer2 = 60, answer3 = 55),
            Question(question = "37+23", answer1 = 60, answer2 = 52, answer3 = 68),
            Question(question = "17+28", answer1 = 45, answer2 = 43, answer3 = 35)
        )
        return questionarray
    }



}