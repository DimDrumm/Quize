package a2018.by.step.myquiz.activity

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.fragment.OnFragmentListener
import a2018.by.step.myquiz.fragment.ResultFragment
import a2018.by.step.myquiz.fragment.SingleSelectionFragment
import a2018.by.step.myquiz.fragment.TextQuestionFragment
import a2018.by.step.myquiz.model.ChoiceQuestion
import a2018.by.step.myquiz.model.TextQuestion
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.Menu

class QuestionActivity : BaseMenuActivity(), OnFragmentListener {
    lateinit var listener: OnActivityListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
    }

    override fun onStart() {
        super.onStart()
        getFragment()
    }

    override fun changeFragment(data: Data) {
        QuizeData.apply {
            QuizeData.promptRemaining(data.isPromtUse)
            QuizeData.answeredQuestionsList.add(data)
        }
        getFragment()
    }

    private fun getFragment() {
        val fragment: Fragment
        val type = QuizeData.getRandomQuestion()
        Log.d("IntroActivity", "getFragment")
        if (type is ChoiceQuestion) {
            Log.d("IntroActivity", "SingleSelectionFragment")
            fragment = SingleSelectionFragment()
            supportFragmentManager.beginTransaction().replace(
                R.id.fl_fragment_container,
                fragment
            ).commit()
            listener = fragment
            listener.getQuestionTypeFromActivity(type)
        } else if (type is TextQuestion) {
            Log.d("IntroActivity", "TextQuestionFragment")
            fragment = TextQuestionFragment()
            supportFragmentManager.beginTransaction().replace(
                R.id.fl_fragment_container,
                fragment
            ).commit()
            listener = fragment
            listener.getQuestionTypeFromActivity(type)
        } else {
            fragment = ResultFragment()
            supportFragmentManager.beginTransaction().replace(
                R.id.fl_fragment_container,
                fragment
            ).commit()
            listener = fragment
            listener.results(QuizeData.getRightQuantityAnswers())
        }
    }
}
