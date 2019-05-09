package a2018.by.step.myquiz.activity

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.data.SharedPreferencesHelper
import a2018.by.step.myquiz.fragment.OnFragmentListener
import a2018.by.step.myquiz.fragment.ResultFragment
import a2018.by.step.myquiz.fragment.SingleSelectionFragment
import a2018.by.step.myquiz.fragment.TextQuestionFragment
import a2018.by.step.myquiz.model.ChoiceQuestion
import a2018.by.step.myquiz.model.Question
import a2018.by.step.myquiz.model.TextQuestion
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem

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
        Log.d("IntroActivity", "${question.toString()}")
        val fragmentManager = supportFragmentManager
        var fragment = fragmentManager.findFragmentById(R.id.fr_single_question_selection)
        fragment = null
        if (fragment == null) {
            when (question) {
                is TextQuestion -> {
                    fragment = TextQuestionFragment()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl_fragment_container,
                        fragment
                    ).commit()
                    listener = fragment
                    getQuestionType(question)
                }
                is ChoiceQuestion -> {
                    fragment = SingleSelectionFragment()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl_fragment_container,
                        SingleSelectionFragment()
                    ).commit()
                    listener = fragment
                    Log.d("IntroActivity", "$listener")
                    getQuestionType(question)
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
        val type = quizeData.getRandomQuestion()
        val fragmentManager = supportFragmentManager
        var fragment = fragmentManager.findFragmentById(R.id.fr_single_question_selection)
        Log.d("IntroActivity", "choseFirstFragment")
        if (type is ChoiceQuestion) {
            if (fragment == null) {
                Log.d("IntroActivity", "SingleSelectionFragment")
                fragment = SingleSelectionFragment()
                supportFragmentManager.beginTransaction().add(
                    R.id.fl_fragment_container,
                    fragment
                ).commit()
                listener = fragment
                getQuestionType(type)
            }
        } else if (type is TextQuestion) {
            if (fragment == null) {
                Log.d("IntroActivity", "TextQuestionFragment")
                fragment = TextQuestionFragment()
                supportFragmentManager.beginTransaction().add(
                    R.id.fl_fragment_container,
                    fragment
                ).commit()
                listener = fragment
                getQuestionType(type)
            }
        }
    }

    override fun getQuestionType(type: Question<*>) {
        listener.getQuestionTypeFromActivity(type)
    }
}
