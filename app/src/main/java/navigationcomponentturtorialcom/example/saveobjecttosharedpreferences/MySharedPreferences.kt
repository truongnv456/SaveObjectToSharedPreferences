package navigationcomponentturtorialcom.example.saveobjecttosharedpreferences

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(private var mContext: Context) {
    companion object {
        private const val MY_SHARED_PREFERENCES = "MY_SHARE_PREFERENCES"
    }

    fun putStringValue(key: String, value: String) {
        val sharedPreferences: SharedPreferences = mContext.getSharedPreferences(
            MY_SHARED_PREFERENCES, Context.MODE_PRIVATE
        )
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getStringValue(key: String): String {
        val sharedPreferences: SharedPreferences = mContext.getSharedPreferences(
            MY_SHARED_PREFERENCES, Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(key, "")!!
    }
}