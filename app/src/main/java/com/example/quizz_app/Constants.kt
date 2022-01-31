package com.example.quizz_app

object Constants {


    fun getQuestions (): ArrayList<Question>{
        val questionsList = ArrayList<Question>()


        val q1 = Question(
            1,
            "What country this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            arrayListOf("Argentina" , "Belice" , "Guatemala" , "San Marino"),
            1,
        )


        val q2 = Question(
            1,
            "What country this flag belong to?",
            R.drawable.ic_flag_of_australia,
            arrayListOf("Argentina" , "Australia" , "Guatemala" , "San Marino"),
            2,
        )
        val q3 = Question(
            1,
            "What country this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            arrayListOf("Argentina" , "Belice" , "Belgium" , "San Marino"),
            3,
        )
        val q4 = Question(
            1,
            "What country this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            arrayListOf("Argentina" , "Belice" , "Guatemala" , "Brazil"),
            4,
        )
        val q5 = Question(
            1,
            "What country this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            arrayListOf("Denmark" , "Belice" , "Guatemala" , "San Marino"),
            1,
        )
        val q6 = Question(
            1,
            "What country this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            arrayListOf("Argentina" , "Fiji" , "Guatemala" , "San Marino"),
            2,
        )


        questionsList.add(q1)
        questionsList.add(q2)
        questionsList.add(q3)
        questionsList.add(q4)
        questionsList.add(q5)
        questionsList.add(q6)
        return questionsList
    }
}