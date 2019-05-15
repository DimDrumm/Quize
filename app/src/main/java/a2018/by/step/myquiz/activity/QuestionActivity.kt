package a2018.by.step.myquiz.activity

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.fragment.SingleSelectionFragment
import android.os.Bundle

class QuestionActivity : BaseMenuActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_fragment,
                SingleSelectionFragment()
            )
            .commit()
    }
}
