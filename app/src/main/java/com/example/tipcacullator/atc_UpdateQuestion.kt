package com.example.tipcacullator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_atc_delete_question.*
import kotlinx.android.synthetic.main.activity_atc_delete_question.Find_btn
import kotlinx.android.synthetic.main.activity_atc_delete_question.idNumber
import kotlinx.android.synthetic.main.activity_atc_update_question.*

class atc_UpdateQuestion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atc_update_question)

        val findButton : Button = findViewById(R.id.Find_btn)
        val updateQuestion : Button = findViewById(R.id.Update_btn)


        idNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                findButton.isEnabled = true
                updateQuestion.isEnabled = true

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
        }

        Update_btn.setOnClickListener {
            var idQuestion: Int = 0
            idQuestion = idNumber.text.toString().toInt() - 1
            val danhsachcauhoi : DanhSachCauHoi = DanhSachCauHoi
            var output: TextView = findViewById(R.id.CauHoiIsFound)
            if(idQuestion > danhsachcauhoi.getSize() || danhsachcauhoi.getSize() < 1)
                output.text = "Number question is invalid"
            else{
                println("idNumber + $idQuestion")
                Intent(this, atc_ChangeCauHoi::class.java).also {
                    it.putExtra("idNumber", idQuestion)
                    startActivity(it)
                }

            }
        }

    }
}