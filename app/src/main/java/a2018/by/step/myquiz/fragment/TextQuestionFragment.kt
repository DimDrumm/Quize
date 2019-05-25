package a2018.by.step.myquiz.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.data.QuestionRepository
import a2018.by.step.myquiz.model.Question
import a2018.by.step.myquiz.model.TextQuestion
import android.content.Context
import kotlinx.android.synthetic.main.fragment_text_question.*
import kotlinx.android.synthetic.main.fragment_text_question.view.*
import timber.log.Timber

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_QUESTION = "question"

/**
 * A simple [Fragment] subclass.
 * Use the [TextQuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TextQuestionFragment : Fragment() {
    var questionCallback: QuestionCallback? = null
    private var question: Question<*>? = null

    override fun onAttach(context: Context?) {
        Timber.d("OnAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("OnCreate ${hashCode()}")
//        arguments?.let {
//            question = it.getString(ARG_QUESTION)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("OnCreateView")
        val view = inflater.inflate(
            R.layout.fragment_text_question,
            container, false
        )
        question = arguments?.getParcelable<TextQuestion>(ARG_QUESTION)
       view.btn_next.setOnClickListener {
            val userAnswer = et_input_answer.text.toString()

            val correctAnswer = arguments?.let {
                it.getParcelable<TextQuestion>(ARG_QUESTION).let { it.rightAnswer }
            }

            if (userAnswer.equals(correctAnswer, true)) {
                questionCallback?.onQuestionAnswered(question!!.id, true)
            } else {
                questionCallback?.onQuestionAnswered(question!!.id, false)
            }
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        Timber.d("OnStart ")
    }

    override fun onPause() {
        Timber.d("OnPause ${hashCode()}")
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        Timber.d("OnResume ${hashCode()}")
        Timber.d("Arguments ${arguments?.getString(ARG_QUESTION)}")
        tv_question_text.text = question?.text
    }

    override fun onStop() {
        Timber.d("OnStop")
        super.onStop()
    }

    override fun onDestroy() {
        Timber.d("OnDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Timber.d("OnDetach")
        super.onDetach()
    }

    companion object {
        //        val question = QuestionRepository.getQuestions()[1]
        @JvmStatic
        fun newInstance(question: Question<*>) =
            TextQuestionFragment().apply {
                //                retainInstance = true
                Timber.d("newInstance")
                arguments = Bundle().apply {
                    putParcelable(ARG_QUESTION, question)
                }
            }
    }
}

interface QuestionCallback {
    fun onQuestionAnswered(id: Int, isCorrect: Boolean)
}
