package a2018.by.step.myquiz.fragment

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.data.QuestionRepository
import a2018.by.step.myquiz.model.ChoiceQuestion
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_single_selection.*
import kotlinx.android.synthetic.main.fragment_single_selection.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SingleSelectionFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_single_selection, container, false)
        val radioGroup = view.rg
        val questionType = questionRepository.getQuestions()[0] as ChoiceQuestion
        view.tv_question_text.text = questionType.text
        view.radioButton1.text = questionType.answers[0]
        view.radioButton2.text = questionType.answers[1]
        view.radioButton3.text = questionType.answers[2]
        radioGroup.setOnCheckedChangeListener { radioGroup, checkedId ->
            when (checkedId) {
                R.id.radioButton1 -> {
                    Toast.makeText(activity, "Right Answer", Toast.LENGTH_SHORT).show()
                    listener?.onFragmentListener()
                }
                R.id.radioButton2, R.id.radioButton3 -> listener?.onFragmentListener()

            }

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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SingleSelectionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SingleSelectionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
