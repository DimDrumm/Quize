package a2018.by.step.myquiz

import a2018.by.step.myquiz.data.SharedPreferencesHelper
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startActivity(
            Intent(this,
                if (SharedPreferencesHelper.getUser(applicationContext)==null){
                    LoginActivity::class.java
                } else {
                    IntroActivity::class.java
                }
        ))

    }
}
