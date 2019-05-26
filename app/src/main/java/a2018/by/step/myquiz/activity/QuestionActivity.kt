package a2018.by.step.myquiz.activity

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.data.QuestionRepository
import a2018.by.step.myquiz.fragment.QuestionCallback
import a2018.by.step.myquiz.fragment.TextQuestionFragment
import android.os.Bundle
import timber.log.Timber

class QuestionActivity : BaseMenuActivity(), QuestionCallback {

    override fun onQuestionAnswered(id: Int, isCorrect: Boolean) {
        Timber.d("on question #$id answer is $isCorrect")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("OnCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        val question = QuestionRepository.getQuestions()[1]
        val fragment = TextQuestionFragment.newInstance(question)
        fragment.questionCallback = this
        Timber.d("question fragment is started: $question")
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container_fragment,
                    fragment
                )
                .commit()
        }
    }

    override fun onStart() {
        Timber.d("OnStart")
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        Timber.d("OnResume ${hashCode()}")

    }

    override fun onPause() {
        Timber.d("OnPause ${hashCode()}")
        super.onPause()
    }

    override fun onStop() {
        Timber.d("OnStop")
        super.onStop()
    }

    override fun onDestroy() {
        Timber.d("OnDestroy")
        super.onDestroy()
    }
}
