package a2018.by.step.myquiz.activity

import a2018.by.step.myquiz.R
import a2018.by.step.myquiz.data.SharedPreferencesHelper
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var etEmail: EditText
    lateinit var etName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etEmail = findViewById(R.id.et_email)
        etName = et_name
        Log.d(LoginActivity::class.java.simpleName,"etName "+etName.hashCode())
        val btn: Button = findViewById(R.id.btn_login)
        btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (!validateName()) {
            etName.error = getString(R.string.validate_name_error)
        } else {
            etName.error = null
        }
        if (!validateEmail()) {
            etEmail.error = getString(R.string.validate_email_error)
        } else {
            etEmail.error = null
        }
        if (validateName() && validateEmail()) {
            SharedPreferencesHelper.setUser(
                applicationContext,
                etName.text.toString(), etEmail.text.toString()
            )
            startActivity(Intent(this, IntroActivity::class.java))
            finish()
        }
    }

    private fun validateName(): Boolean {
        return etName.text.toString().length in 5..16
    }

    private fun validateEmail(): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(etEmail.text.toString()).matches()
    }
}
