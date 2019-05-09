package a2018.by.step.myquiz.activity

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.data.SharedPreferencesHelper
import a2018.by.step.myquiz.fragment.OnFragmentListener
import a2018.by.step.myquiz.fragment.ResultFragment
import a2018.by.step.myquiz.fragment.TextQuestionFragment
import a2018.by.step.myquiz.fragment.SingleSelectionFragment
import a2018.by.step.myquiz.model.ChoiceQuestion
import a2018.by.step.myquiz.model.TextQuestion
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import java.lang.RuntimeException
import java.util.*

class IntroActivity : AppCompatActivity(), OnFragmentListener {
    private val quizeData = QuizeData()
    lateinit var listener: OnActivityListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        Log.d("IntroActivity", "rendering layout")
        choseFirstFragment()
    }

    override fun onResume() {
        super.onResume()
//        TextQuestionFragment.newInstance()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_logout -> logout()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun logout() {
        SharedPreferencesHelper.clearData(applicationContext)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }


    override fun changeFragment() {
        val question = quizeData.getRandomQuestion()
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentById(R.id.fr_single_question_selection)
        if (fragment == null) {
            when (question) {
                is TextQuestion -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl_fragment_container,
                        TextQuestionFragment()
                    ).commit()
                }
                is ChoiceQuestion -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl_fragment_container,
                        SingleSelectionFragment()
                    ).commit()
                }
                null -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl_fragment_container,
                        ResultFragment()
                    ).commit()
                }
            }
        }

    }

    private fun choseFirstFragment() {
        Log.d("IntroActivity", "choseFirstFragment")
//        if (Random().nextInt(2) == 1) {
        val fragmentManager = supportFragmentManager
        var fragment = fragmentManager.findFragmentById(R.id.fr_single_question_selection)
        if (fragment == null) {
            Log.d("IntroActivity", "SingleSelectionFragment")
            fragment = SingleSelectionFragment()
            supportFragmentManager.beginTransaction().add(
                R.id.fl_fragment_container,
                fragment
            ).commit()
            listener = fragment
        } else {
            Log.d("IntroActivity", "TextQuestionFragment")
            fragment = TextQuestionFragment()
            supportFragmentManager.beginTransaction().add(
                R.id.fl_fragment_container,
                fragment
            ).commit()
          listener = fragment
        }
    }

    override fun getQuestionType() {
        Log.d("IntroActivity", "give Question type to activity")
        when (val question = quizeData.getRandomQuestion()) {
            is TextQuestion -> listener.getQuestionTypeFromActivity(question)
            is ChoiceQuestion -> listener.getQuestionTypeFromActivity(question)
        }
    }
}
