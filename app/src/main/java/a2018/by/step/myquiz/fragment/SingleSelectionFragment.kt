package a2018.by.step.myquiz.fragment

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.model.Question
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SingleSelectionFragment : Fragment() {
    init {
        Log.d("SingleSelectionFragment", "SingleSelectionFragment init")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d("SingleSelectionFragment", "onAttachMethod")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SingleSelectionFragment", "OnCreateMethod")
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.d("SingleSelectionFragment", "OnCreateViewMethod")
        return inflater.inflate(R.layout.fragment_single_selection,
            container,false)
    }

    override fun onStart() {
        super.onStart()
        Log.d("SingleSelectionFragment", "OnStartMethod")
    }

}