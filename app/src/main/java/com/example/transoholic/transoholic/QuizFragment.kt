package com.example.transoholic

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.transoholic.R
import com.example.transoholic.databinding.FragmentQuizBinding

//Reference to udacities kotlin fundamentals

class QuizFragment : Fragment() {
    data class Question(
        val text: String,
        val answers: List<String>
    )

    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (or better yet, not define the questions in code...)
    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "Punainen is English?",
            answers = listOf("Red", "Blue", "Green")
        ),
        Question(
            text = "Suomi in English?",
            answers = listOf("Finland", "Funland", "Wonderland")
        ),
        Question(
            text = "Omena in English?",
            answers = listOf("Apple", "Orange", "Banana")
        ),
        Question(
            text = "Sininen in English?",
            answers = listOf("Blue", "Glue", "Super glue")
        ),
        Question(
            text = "Musta in English?",
            answers = listOf("Black", "Green", "Light blue")
        ),
        Question(
            text = "Ruskea in English?",
            answers = listOf("Brown", "Down", "Town")
        ),
        Question(
            text = "Vauva in English?",
            answers = listOf("Baby", "Young", "Adult")
        ),
        Question (
            text = "Aurinko in English?",
            answers = listOf("Sun", "Moon", "Star")
    )
    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = Math.min((questions.size + 1) / 2, 3)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentQuizBinding>(
            inflater, R.layout.fragment_quiz, container, false
        )

        randomizeQuestions()
        binding.quiz = this

        // Set the onClickListener for the submitButton
        binding.submitButton.setOnClickListener { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            // if nothing is selected
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                }
                // correct answers are at index 0
                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++
                    // proceeding to next question
                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        //when all 3 answers are right
                        view.findNavController().navigate(
                            QuizFragmentDirections.quizToRight(
                                numQuestions,
                                questionIndex
                            )
                        )
                    }
                } else {
                    // If answer is wrong
                    view.findNavController().navigate(QuizFragmentDirections.quizToWrong())
                }
            }
        }
        return binding.root
    }

    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.home_question, questionIndex + 1, numQuestions)
    }
}