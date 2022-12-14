package com.pr7.kotlin_quizapp.model.viewmodel

import androidx.lifecycle.ViewModel
import com.pr7.kotlin_quizapp.model.questionmodel.Question
import com.pr7.kotlin_quizapp.model.repository.QuestionRepository

class MainViewModel constructor(

) :ViewModel(){
    var a=-1
    val questionRepository: QuestionRepository= QuestionRepository()

    fun getAllData():Array<Question>{
        return questionRepository.getAllQuestion()
    }

    fun showQuestions():Question{
        a++
        if (a==getAllData().size){
            a--
            return getAllData().get(getAllData().size-1)
        }else{
            var question=getAllData().get(a)
            return question
        }
    }



}