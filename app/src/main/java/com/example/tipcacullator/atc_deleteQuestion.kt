package com.example.tipcacullator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_atc_delete_question.*

class atc_deleteQuestion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atc_delete_question)
        val findButton : Button = findViewById(R.id.Find_btn)
        val deleteButton : Button = findViewById(R.id.Delete_btn)


        idNumber.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                findButton.isEnabled = true
                deleteButton.isEnabled = true
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        Find_btn.setOnClickListener {

            var idQuestion: Int = 0
            idQuestion = idNumber.text.toString().toInt() - 1
            val danhsachcauhoi : DanhSachCauHoi = DanhSachCauHoi
            var output: TextView = findViewById(R.id.CauHoiIsFound)
            if(idQuestion > danhsachcauhoi.getSize() || danhsachcauhoi.getSize() < 1)
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
            Delete_btn.setOnClickListener {
                var idQuestion: Int = 0
                idQuestion = idNumber.text.toString().toInt() - 1
                var output: TextView = findViewById(R.id.CauHoiIsFound)
                if(idQuestion < 0 || danhsachcauhoi.getSize() < 1)
                    output.text = "You must find out your question you want to delete first"
                else{
                    val danhsachcauhoi = DanhSachCauHoi
                    danhsachcauhoi.xoaCauHoi(idQuestion)
                    output.text = "Question is deleted"
                }
            }


        }

    }
}