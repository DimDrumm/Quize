package a2018.by.step.myquiz.activity

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.data.QuestionRepository
import a2018.by.step.myquiz.fragment.TextQuestionFragment
import a2018.by.step.myquiz.model.TextQuestion
import android.os.Bundle
import timber.log.Timber

class QuestionActivity : BaseMenuActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("OnCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        if (savedInstanceState == null) {
            val question = QuestionRepository.getQuestions()[1] as TextQuestion
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container_fragment,
                    TextQuestionFragment
                        .newInstance(question)
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
