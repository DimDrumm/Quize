package a2018.by.step.myquiz.data

import a2018.by.step.myquiz.model.User
import android.content.Context

object SharedPreferencesHelper {
    val propertiesName = "properties"
    private const val propertyNameName = "name"
    private const val propertyEmailName = "email"

    fun getUser(context: Context): User? {
        context.getSharedPreferences(propertiesName, Context.MODE_PRIVATE).apply {
            val name = this.getString(propertyNameName, null)
            val email = this.getString(propertyEmailName, name)

            if (name != null || email != null) {
                return User(name!!, email!!)
            } else {
                return null
            }
        }
    }

    fun setUser(context: Context, name: String, email: String) {
        context.getSharedPreferences(propertiesName,Context.MODE_PRIVATE).edit().apply {
            this.putString(propertyNameName,name)
            this.putString(propertyEmailName,email)
        }.apply()
    }

    fun clearData(context: Context){
        context.getSharedPreferences(propertiesName,Context.MODE_PRIVATE).edit().clear().apply()
    }
}

object ResourceHelper {
    fun f() {
    }

}