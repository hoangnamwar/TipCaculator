package com.example.tipcacullator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import com.example.tipcacullator.databinding.ActivityDetailEditBinding
import kotlinx.android.synthetic.main.activity_detail_edit.*

class DetailEdit : AppCompatActivity() {

    private lateinit var binding: ActivityDetailEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = "Chỉnh sửa chi tiết"
        actionBar.setDisplayHomeAsUpEnabled(true)

        AC_button_ok.setOnClickListener {
            val question = binding.ACQuestionForm.text.toString()
            val answerA = binding.ACAnswerAForm.text.toString()
            val answerB = binding.ACAnswerBForm.text.toString()
            val answerC = binding.ACAnswerCForm.text.toString()
            val answerD = binding.ACAnswerDForm.text.toString()
            val answerCorrect = binding.ACAnswerCorrectForm.text.toString().toInt()

            val cau_hoi : CauHoi = CauHoi(question, answerCorrect)
            cau_hoi.setDapAn(answerA, answerB, answerC, answerD)
            DanhSachCauHoi.themCauHoi(cau_hoi)
        }

        AC_button_back.setOnClickListener { actionBar.setDisplayHomeAsUpEnabled(true) }
    }


}