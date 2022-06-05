package com.example.tipcacullator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val totalQuestions=intent.getIntExtra("TOTAL_QUESTIONS", 0)
        val correctAnswers=intent.getIntExtra("CORRECT_ANSWERS",0)
        tv_score.text = "Your score is $correctAnswers out of $totalQuestions"
        btn_finish.setOnClickListener{
            startActivity(Intent(this, Home::class.java))
            finish()
        }

    }
}