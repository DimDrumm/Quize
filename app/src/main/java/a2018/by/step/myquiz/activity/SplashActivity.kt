package a2018.by.step.myquiz.activity

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.data.SharedPreferencesHelper
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("SplashActivity","SplashActivity Start")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startActivity(
            Intent(
                this,
                if (SharedPreferencesHelper.getUser(applicationContext) == null) {
                    LoginActivity::class.java
                } else {
                    IntroActivity::class.java
                }
            )
        )
        finish()
    }
}
