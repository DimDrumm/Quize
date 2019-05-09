package a2018.by.step.myquiz.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.activity.OnActivityListener
import a2018.by.step.myquiz.data.QuestionRepository
import a2018.by.step.myquiz.model.Question
import kotlinx.android.synthetic.main.fragment_text_question.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TextQuestionFragment : Fragment(),OnActivityListener {
    val questionRepository = QuestionRepository
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_text_question, container, false)
        view.button_Ok.setOnClickListener {
            listener?.changeFragment()
        }
        return view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance() = TextQuestionFragment()
    }

    override fun getQuestionTypeFromActivity(question: Question<*>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
