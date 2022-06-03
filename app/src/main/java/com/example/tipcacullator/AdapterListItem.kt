package com.example.tipcacullator

import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.text.FieldPosition

class AdapterListItem(
    private val context: Activity,
    private val arrayList: ArrayList<CauHoi>
) : ArrayAdapter<CauHoi>(context, R.layout.list_item, arrayList)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view:View = inflater.inflate(R.layout.list_item, null)

        val question : TextView = view.findViewById(R.id.textQuestion)
        var answerA : TextView = view.findViewById(R.id.textAnswerA)
        var answerB : TextView = view.findViewById(R.id.textAnswerB)
        var answerC : TextView = view.findViewById(R.id.textAnswerC)
        var answerD : TextView = view.findViewById(R.id.textAnswerD)


        question.text = "id: $position    ${arrayList[position].getCauHoi()}"
        answerA.text = arrayList[position].getAllDapAn().get(0)
        answerB.text = arrayList[position].getAllDapAn().get(1)
        answerC.text = arrayList[position].getAllDapAn().get(2)
        answerD.text = arrayList[position].getAllDapAn().get(3)
        var correctAnswer = arrayList[position].getDapAnDung()

        when (correctAnswer) {
            0 -> answerA.setTextColor(Color.parseColor("#4bb543"))
            1 -> answerB.setTextColor(Color.parseColor("#4bb543"))
            2 -> answerC.setTextColor(Color.parseColor("#4bb543"))
            3 -> answerD.setTextColor(Color.parseColor("#4bb543"))
        }


        return view
    }
}