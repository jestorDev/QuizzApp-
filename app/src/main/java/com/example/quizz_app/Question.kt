package com.example.quizz_app

data class Question(
    val id: Int ,
    val content : String ,
    val image : Int,
    val options : ArrayList<String>,
    val correctAnswer : Int
)
