package com.example.quizz_app

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.TypefaceSpan
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlin.math.log

class QuizQuestionActivity : AppCompatActivity() , View.OnClickListener {

    private var currentSelection : Int = 0

    private var progressBar : ProgressBar? = null
    private var tvProvgress : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null
    private var tvAns1 : TextView? = null
    private var tvAns2 : TextView? = null
    private var tvAns3 : TextView? = null
    private var tvAns4 : TextView? = null
    private var actualOption  : Int = 0
    private var questionList : ArrayList<Question>? = null;

    private var btnSubmit : Button ? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        setLayoutElems()

        questionList =  Constants.getQuestions()


        tvAns1?.setOnClickListener(this)
        tvAns2?.setOnClickListener(this)
        tvAns3?.setOnClickListener(this)
        tvAns4?.setOnClickListener(this)

        btnSubmit?.setOnClickListener(this)
        setQuestion(6)
        setOptionsStyle()


    }

    private fun setOptionsStyle() {
        val options = arrayListOf<TextView?>( tvAns1,tvAns2,tvAns3,tvAns4)

        for (option in options){
            option!!.setTextColor(Color.parseColor("#222222"))
            option?.typeface =  Typeface.DEFAULT
            option?.background = ContextCompat.getDrawable(
                this,
                R.drawable.option_border
            )
        }
    }

    private fun selectedOptionStyle(selectedOption :  Int) {
        setOptionsStyle()

        actualOption = selectedOption

        val options = arrayListOf<TextView?>( tvAns1,tvAns2,tvAns3,tvAns4)
        val tvSelected =  options[selectedOption -1];


        tvSelected?.setTextColor(Color.parseColor("#7f17b3"))

        tvSelected?.setTypeface( tvSelected.typeface , Typeface.BOLD);
        tvSelected?.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_border
        )

    }




    private fun setLayoutElems() {
        progressBar = findViewById(R.id.progress_bar)
        tvProvgress = findViewById(R.id.tv_prograss)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        tvAns1 = findViewById(R.id.tv_ans1)
        tvAns2 = findViewById(R.id.tv_ans2)
        tvAns3 = findViewById(R.id.tv_ans3)
        tvAns4 = findViewById(R.id.tv_ans4)

        btnSubmit = findViewById(R.id.btn_start)
    }

    private fun setQuestion(
        actual: Int
    ) {

        val total = questionList?.size ?: 0

        val actualQuestion  : Question = questionList!![actual-1]

        progressBar?.progress = actual
        progressBar?.max = total
        tvProvgress?.text = actual.toString() + " / " + total.toString()

        tvQuestion?.text = actualQuestion.content
        ivImage?.setImageResource(actualQuestion.image)
        tvAns1?.text = actualQuestion.options[0]
        tvAns2?.text = actualQuestion.options[1]
        tvAns3?.text = actualQuestion.options[2]
        tvAns4?.text = actualQuestion.options[3]


        if (actual == questionList!!.size)
            btnSubmit?.text =  "Finish"
        else
            btnSubmit?.text =  "Next"




    }


    override fun onClick( selectedV: View?) {
        when (selectedV?.id){
            R.id.tv_ans1 -> {
                selectedOptionStyle(1)
            }
            R.id.tv_ans2 -> {
                selectedOptionStyle(2)
            }
            R.id.tv_ans3 -> {
                selectedOptionStyle(3)
            }
            R.id.tv_ans4 -> {
                selectedOptionStyle(4)
            }
            R.id.btn_submit -> {

            }
        }

    }
}