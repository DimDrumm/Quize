package a2018.by.step.myquiz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var etEmail: EditText
    lateinit var etName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etEmail = findViewById(R.id.et_email)
        etName = et_name
        val btn: Button = findViewById<Button>(R.id.btn_login)
        btn.setOnClickListener(this)
    }

    override fun onCreateOptionalMenu(menu: Menu?):Boolean{
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.
        }
        return super.onOptionsItemSelected(item)
    }













//    override fun onClick(v: View?) {
//        if (!validateName()) {
//            etName.error = getString(R.string.vali)
//        } else {
//            etName.error = null
//        }
//        if (!validateEmail) {
//            etEmail.error =
//        }
//    }
//
//    private fun validateName(): Boolean {
//        return etName.text.toString().length < 4 && etName.text.toString().length <= 16
//    }
//
//    private fun validateEmail(): Boolean {
//        return etEmail.text.toString().length
//    }
}
