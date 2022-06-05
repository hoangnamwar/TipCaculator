package com.example.tipcacullator

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_exam.*

class Exam : AppCompatActivity(), View.OnClickListener
{

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<CauHoi>? = null

    private var mCorrectAnswers: Int = 0
    lateinit var optionTextView: TextView
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam)
        mQuestionsList = DanhSachCauHoi.getAllCauHoi()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)

        btn_submit.setOnClickListener(this)
    }

        override fun onClick(v: View?) {

            when (v?.id) {

                R.id.tv_option_one -> {
                    selectedOptionView(tv_option_one, 1)
                }

                R.id.tv_option_two -> {
                    selectedOptionView(tv_option_two, 2)
                }

                R.id.tv_option_three -> {
                    selectedOptionView(tv_option_three, 3)
                }

                R.id.tv_option_four -> {
                    selectedOptionView(tv_option_four, 4)
                }

                R.id.btn_submit -> {

                    if (mSelectedOptionPosition == 0) {

                        mCurrentPosition++

                        when {

                            mCurrentPosition <= mQuestionsList!!.size -> {

                                setQuestion()
                            }
                            else -> {
//  -----------------------  finninsh ----------------------
                                val intent = Intent(this, Result::class.java)
                                intent.putExtra("CORRECT_ANSWERS", mCorrectAnswers)
                                intent.putExtra("TOTAL_QUESTIONS", mQuestionsList!!.size)
                                startActivity(intent)
//                                println("success")
                            }
                        }
                    } else {
                        val question = mQuestionsList?.get(mCurrentPosition - 1)

                        if (question!!.getDapAnDung() + 1 != mSelectedOptionPosition) {
                            answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                        }
                        else{
                            mCorrectAnswers++
                        }

                        answerView(question.getDapAnDung() + 1, R.drawable.correct_option_border_bg)

                        if (mCurrentPosition == mQuestionsList!!.size) {
                            btn_submit.text = "FINISH"
                        } else {
                            btn_submit.text = "GO TO NEXT QUESTION"
                        }

                        mSelectedOptionPosition = 0
                    }
                }
            }
        }

        private fun setQuestion() {

            val question = mQuestionsList!!.get(mCurrentPosition - 1) // Getting the question from the list with the help of current position.

            defaultOptionsView()

            if (mCurrentPosition == mQuestionsList!!.size) {
                btn_submit.text = "FINISH"
            } else {
                btn_submit.text = "SUBMIT"
            }

            progressBar.max = mQuestionsList!!.size
            progressBar.progress = mCurrentPosition
            tv_progress.text = "$mCurrentPosition" + "/" + mQuestionsList!!.size

            tv_question.text = question.getCauHoi()
            tv_option_one.text = question.getAllDapAn().get(0)
            tv_option_two.text = question.getAllDapAn().get(1)
            tv_option_three.text = question.getAllDapAn().get(2)
            tv_option_four.text = question.getAllDapAn().get(3)
        }

        private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

            defaultOptionsView()

            mSelectedOptionPosition = selectedOptionNum

            tv.setTextColor(
                Color.parseColor("#363A43")
            )
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(
                this@Exam,
                R.drawable.selected_option_border_bg
            )
        }

        private fun defaultOptionsView() {

            val options = ArrayList<TextView>()
            options.add(0, tv_option_one)
            options.add(1, tv_option_two)
            options.add(2, tv_option_three)
            options.add(3, tv_option_four)

            for (option in options) {
                option.setTextColor(Color.parseColor("#7A8089"))
                option.typeface = Typeface.DEFAULT
                option.background = ContextCompat.getDrawable(
                    this@Exam,
                    R.drawable.default_option_border_bg
                )
            }
        }

        private fun answerView(answer: Int, drawableView: Int) {

            when (answer) {

                1 -> {
                    tv_option_one.background = ContextCompat.getDrawable(
                        this@Exam,
                        drawableView
                    )
                }
                2 -> {
                    tv_option_two.background = ContextCompat.getDrawable(
                        this@Exam,
                        drawableView
                    )
                }
                3 -> {
                    tv_option_three.background = ContextCompat.getDrawable(
                        this@Exam,
                        drawableView
                    )
                }
                4 -> {
                    tv_option_four.background = ContextCompat.getDrawable(
                        this@Exam,
                        drawableView
                    )
                }
            }
        }
}