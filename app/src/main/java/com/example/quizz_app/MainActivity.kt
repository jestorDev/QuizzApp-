package com.example.quizz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart: Button = findViewById(R.id.btn_start)
        val etName : EditText = findViewById(R.id.et_name)

        btnStart.setOnClickListener {

            if (etName.text.isEmpty())
                Toast.makeText(this , "Please enter text" , Toast.LENGTH_SHORT).show()
            else{
                Toast.makeText(this , "Name : " + etName.text , Toast.LENGTH_SHORT).show()
                val myIntent  = Intent(this , QuizQuestionActivity::class.java )
                startActivity(myIntent)
                finish()
            }

        }
    }
}