package com.example.tipcacullator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.tipcacullator.databinding.ActivityListQuestionBinding

class  ListQuestion : AppCompatActivity() {

    private lateinit var binding : ActivityListQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listview.adapter = AdapterListItem(this, DanhSachCauHoi.getAllCauHoi())
    }
}