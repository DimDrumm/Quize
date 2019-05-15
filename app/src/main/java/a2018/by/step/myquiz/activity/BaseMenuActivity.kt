package a2018.by.step.myquiz.activity

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.data.SharedPreferencesHelper
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

abstract class BaseMenuActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_logout -> logout()
            R.id.prompt -> Toast.makeText(
                applicationContext,
                QuizeData.promptQuantity.toString(),
                Toast.LENGTH_SHORT
            ).show()
            R.id.menu_Exit -> {
                startActivity(
                    Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME).
                        setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                )
            }
            R.id.user_info -> startActivity(Intent(applicationContext, UserInfoActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun logout() {
        SharedPreferencesHelper.clearData(applicationContext)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}