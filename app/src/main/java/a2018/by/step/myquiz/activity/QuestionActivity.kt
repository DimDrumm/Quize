package a2018.by.step.myquiz.activity

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.data.QuestionRepository
import a2018.by.step.myquiz.fragment.SingleSelectionFragment
import a2018.by.step.myquiz.fragment.TextQuestionFragment
import a2018.by.step.myquiz.model.Question
import android.content.Context
import android.os.Bundle
import timber.log.Timber

class QuestionActivity : BaseMenuActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
       if (savedInstanceState == null) {
           val q = QuestionRepository.getQuestions()[0]
           supportFragmentManager.beginTransaction()
               .replace(
                   R.id.container_fragment,
                   TextQuestionFragment.newInstance(/*q*/)
               )
       }
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
    }

    override fun onPause() {
        super.onPause()
        Timber.d("onPause ${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy")
    }
}
