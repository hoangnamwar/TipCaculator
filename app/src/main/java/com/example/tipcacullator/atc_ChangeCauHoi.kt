package com.example.tipcacullator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tipcacullator.databinding.ActivityDetailEditBinding
import kotlinx.android.synthetic.main.activity_atc_change_cau_hoi.*
import kotlinx.android.synthetic.main.activity_detail_edit.*
import kotlinx.android.synthetic.main.activity_detail_edit.AC_answer_A_form
import kotlinx.android.synthetic.main.activity_detail_edit.AC_answer_B_form
import kotlinx.android.synthetic.main.activity_detail_edit.AC_answer_C_form
import kotlinx.android.synthetic.main.activity_detail_edit.AC_answer_D_form
import kotlinx.android.synthetic.main.activity_detail_edit.AC_answer_correct_form
import kotlinx.android.synthetic.main.activity_detail_edit.AC_button_ok
import kotlinx.android.synthetic.main.activity_detail_edit.AC_question_form


class atc_ChangeCauHoi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atc_change_cau_hoi)
        val idNumber = intent.getIntExtra("idNumber", -1)

        AC_button_ok.setOnClickListener {
            val question = AC_question_form.text.toString()
            val answerA = AC_answer_A_form.text.toString()
            val answerB = AC_answer_B_form.text.toString()
            val answerC = AC_answer_C_form.text.toString()
            val answerD = AC_answer_D_form.text.toString()
            val answerCorrect = AC_answer_correct_form.text.toString().toInt()

            val cau_hoi : CauHoi = CauHoi(question, answerCorrect)
            cau_hoi.setDapAn(answerA, answerB, answerC, answerD)
            DanhSachCauHoi.suaCauHoi(idNumber, cau_hoi)

//            val file = HandleFile()
//            file.writeFile()

            Toast.makeText(this, "sửa thành công", Toast.LENGTH_SHORT).show()

            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}