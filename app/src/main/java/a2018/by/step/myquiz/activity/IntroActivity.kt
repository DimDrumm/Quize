package a2018.by.step.myquiz.activity

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.data.SharedPreferencesHelper
import a2018.by.step.myquiz.fragment.QuestionFragment
import a2018.by.step.myquiz.fragment.SingleSelectionFragment
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

class IntroActivity : AppCompatActivity(),SingleSelectionFragment.OnFragmentInteractionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        Log.d("IntroActivity","Test")
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,SingleSelectionFragment()).commit()
    }

    override fun onResume() {
        super.onResume()
        QuestionFragment.newInstance()
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

    interface onActivityDataListener {
        fun onActivityDataListener()
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
