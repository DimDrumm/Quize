package a2018.by.step.myquiz.fragment

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.activity.OnActivityListener
import a2018.by.step.myquiz.model.ChoiceQuestion
import a2018.by.step.myquiz.model.Question
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_single_selection.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SingleSelectionFragment : Fragment(), OnActivityListener {
    lateinit var questionType: ChoiceQuestion
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentListener? = null
    lateinit var radioButton: RadioButton
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
        for (i in 0 until questionType.answers.size) {
            radioButton = RadioButton(activity)
            radioButton.id = i
            radioButton.text = questionType.answers[i]
            radioGroup.addView(radioButton)
        }
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            //TODO work only for first radioButton in the list
            when (checkedId) {
                0 -> {
                    Toast.makeText(activity, "Right Answer", Toast.LENGTH_SHORT).show()
                    listener?.changeFragment()
                }
                1,2 -> listener?.changeFragment()
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

    override fun getQuestionTypeFromActivity(question: Question<*>) {
        Log.d("SingleSelectionFragment", "getQuestionTypeFromActivity")
        questionType = question as ChoiceQuestion
        Log.d("SingleSelectionFragment", "${questionType.toString()}")
    }
}
