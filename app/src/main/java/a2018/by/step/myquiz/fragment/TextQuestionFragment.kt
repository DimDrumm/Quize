package a2018.by.step.myquiz.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.data.QuestionRepository
import android.content.Context
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate")
        Timber.d("${Companion.question}")
//        arguments?.let {
//            question = it.getString(ARG_QUESTION)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView")
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_text_question,container,false)
        view.tv_question_text.text.
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Timber.d("onAttach")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.d("onDetach")
    }
    override fun onStart() {
        super.onStart()
        Timber.d("onStart")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("onStop")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume ${hashCode()}")
        Timber.d("Arguments ${arguments?.getString(ARG_QUESTION)}")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("onPause ${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy")
    }

    companion object {
        val question = QuestionRepository.getQuestions()[1]
        @JvmStatic
        fun newInstance(/*question: Question<*>*/) =
            TextQuestionFragment().apply {
                Timber.d("newInstance")
                arguments = Bundle().apply {
                }
            }
    }

}
