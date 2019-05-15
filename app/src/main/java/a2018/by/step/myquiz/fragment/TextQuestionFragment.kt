package a2018.by.step.myquiz.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.model.Question

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
    private var question: Question<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            question = it.getString(ARG_QUESTION)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text_question, container, false)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TextQuestionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(question: Question<*>) =
            TextQuestionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_QUESTION,question)
                }
            }
    }
}
