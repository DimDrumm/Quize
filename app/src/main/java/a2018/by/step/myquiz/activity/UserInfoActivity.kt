package a2018.by.step.myquiz.activity

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.data.SharedPreferencesHelper
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_user_info.*

class UserInfoActivity : AppCompatActivity() {
    val sharedPreference = SharedPreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
    }
}
