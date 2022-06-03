package com.example.tipcacullator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_atc_delete_question.*

class atc_deleteQuestion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atc_delete_question)

        button.setOnClickListener {
            val idQuestion = idNumber.text.toString().toInt() - 1
            val danhsachcauhoi : DanhSachCauHoi = DanhSachCauHoi
            var output: TextView = findViewById(R.id.CauHoiIsFound)
            if(idQuestion > danhsachcauhoi.getSize())
                output.text = "Number question is invalid"
            else{
                val foundQuestion : CauHoi = danhsachcauhoi.getCauHoi(idQuestion)
                val question = foundQuestion.getCauHoi()
                val answer: MutableList<String> = foundQuestion.getAllDapAn()
                var correctAnswer :String = "A"

                when(foundQuestion.getDapAnDung())
                {
                    1-> correctAnswer = "A"
                    2-> correctAnswer = "B"
                    3-> correctAnswer = "C"
                    4-> correctAnswer = "D"
                }
                output.text = "Question: $question\nA: ${answer[0]}\nB: ${answer[1]}\nC: ${answer[2]}\nD: ${answer[3]}\nCorrect answer: $correctAnswer"
            }

        }

    }
}