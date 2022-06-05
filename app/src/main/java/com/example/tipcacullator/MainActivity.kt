package com.example.tipcacullator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_addQuestion.setOnClickListener {
            val intent = Intent(this, DetailEdit::class.java)
            startActivity(intent)
        }

        btn_deleteQuestion.setOnClickListener {
            val intent = Intent(this, atc_deleteQuestion::class.java)
            startActivity(intent)
        }
        btn_updateQuestion.setOnClickListener {
            val intent = Intent(this, atc_UpdateQuestion::class.java)
            startActivity(intent)
        }
        btn_showListQuestion.setOnClickListener {
            val intent = Intent(this, ListQuestion::class.java)
            startActivity(intent)
        }

    }
}