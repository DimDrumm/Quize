package a2018.by.step.myquiz.activity

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.data.SharedPreferencesHelper
import a2018.by.step.myquiz.fragment.QuestionFragment
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_intro.*
import kotlinx.android.synthetic.main.activity_login.*

class IntroActivity : BaseMenuActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        btn_start.setOnClickListener {
            startActivity(Intent(this, QuestionActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        QuestionFragment.newInstance()
    }


}
