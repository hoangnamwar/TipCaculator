package com.example.tipcacullator

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_exam.*

class Exam : AppCompatActivity(), View.OnClickListener
{

    private var mCurrentPosition: Int = 1 // Default and the first question position
    private var mQuestionsList: ArrayList<CauHoi>? = null
//    private var muserName:String? = null

    private var mCorrectAnswers: Int = 0

    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam)

//        muserName  = intent.getStringExtra(Constants.USER_NAME)
        mQuestionsList = DanhSachCauHoi.getAllCauHoi()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)

        // TODO(STEP 1: Adding a click event for submit button.)
        // START
        btn_submit.setOnClickListener(this)
        // END
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

                // TODO(STEP 2: Adding a click event for submit button. And change the questions and check the selected answers.)
                // START
                R.id.btn_submit -> {

                    if (mSelectedOptionPosition == 0) {

                        mCurrentPosition++

                        when {

                            mCurrentPosition <= mQuestionsList!!.size -> {

                                setQuestion()
                            }
                            else -> {
//  -----------------------  finninsh ----------------------
//                                val intent = Intent(this, ResultActivity::class.java)
//                                intent.putExtra(Constants.USER_NAME, muserName)
//                                intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
//                                intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
//                                startActivity(intent)
                                println("success")
                            }
                        }
                    } else {
                        val question = mQuestionsList?.get(mCurrentPosition - 1)

                        // This is to check if the answer is wrong
                        if (question!!.getDapAnDung() != mSelectedOptionPosition) {
//                            answerView(mSelectedOptionPosition)
//                            answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                        }
                        else{
                            mCorrectAnswers++
                        }

                        // This is for correct answer
//                        answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

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

        /**
         * A function for setting the question to UI components.
         */
        private fun setQuestion() {

            val question = mQuestionsList!!.get(mCurrentPosition - 1) // Getting the question from the list with the help of current position.

            defaultOptionsView()

            // TODO (STEP 6: Check here if the position of question is last then change the text of the button.)
            // START
            if (mCurrentPosition == mQuestionsList!!.size) {
                btn_submit.text = "FINISH"
            } else {
                btn_submit.text = "SUBMIT"
            }
            // END

            progressBar.progress = mCurrentPosition
            tv_progress.text = "$mCurrentPosition" + "/" + progressBar.getMax()

            tv_question.text = question.getCauHoi()
            tv_option_one.text = question.getAllDapAn().get(0)
            tv_option_two.text = question.getAllDapAn().get(1)
            tv_option_three.text = question.getAllDapAn().get(2)
            tv_option_four.text = question.getAllDapAn().get(3)
        }

        /**
         * A function to set the view of selected option view.
         */
        private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

            defaultOptionsView()

            mSelectedOptionPosition = selectedOptionNum

            tv.setTextColor(
                Color.parseColor("#363A43")
            )
            tv.setTypeface(tv.typeface, Typeface.BOLD)
//            tv.background = ContextCompat.getDrawable(
//                this@Exam,
//                R.drawable.selected_option_border_bg
//            )
        }

        /**
         * A function to set default options view when the new question is loaded or when the answer is reselected.
         */
        private fun defaultOptionsView() {

            val options = ArrayList<TextView>()
            options.add(0, tv_option_one)
            options.add(1, tv_option_two)
            options.add(2, tv_option_three)
            options.add(3, tv_option_four)

            for (option in options) {
                option.setTextColor(Color.parseColor("#7A8089"))
                option.typeface = Typeface.DEFAULT
//                option.background = ContextCompat.getDrawable(
//                    this@Exam,
//                    R.drawable.default_option_border_bg
//                )
            }
        }

        // TODO (STEP 3: Create a function for answer view.)
        // START
        /**
         * A function for answer view which is used to highlight the answer is wrong or right.
         */
        private fun answerView(answer: Int, drawableView: Int) {

            when (answer) {

                1 -> {
                    tv_option_one.setBackgroundColor(Color.parseColor("#4BB543"))
                }
                2 -> {
                    tv_option_two.setBackgroundColor(Color.parseColor("#4BB543"))
                }
                3 -> {
                    tv_option_three.setBackgroundColor(Color.parseColor("#4BB543"))
                }
                4 -> {
                    tv_option_four.setBackgroundColor(Color.parseColor("#4BB543"))
                }
            }
        }
        // END

}