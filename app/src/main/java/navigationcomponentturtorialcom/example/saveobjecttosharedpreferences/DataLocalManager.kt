package navigationcomponentturtorialcom.example.saveobjecttosharedpreferences

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import navigationcomponentturtorialcom.example.saveobjecttosharedpreferences.model.User

class DataLocalManager {
    companion object {
        private var instance: DataLocalManager? = null

        private const val PREF_OBJECT_USER = "PREF_OBJECT_USERS"

        fun init(context: Context) {
            instance = DataLocalManager()
            instance?.mySharedPreferences = MySharedPreferences(context)
        }

        fun getInstance(): DataLocalManager {
            if (instance == null) {
                instance = DataLocalManager()
            }
            return instance!!
        }

        fun setUser(user: User) {
            // Serialization: chuyển obj -> string
            val gson = Gson()
            val json: String = gson.toJson(user)

            DataLocalManager.getInstance().mySharedPreferences?.putStringValue(
                PREF_OBJECT_USER,
                json
            )
        }

        fun getUser(): User? {
            val strJsonUser: String? =
                DataLocalManager.getInstance().mySharedPreferences?.getStringValue(PREF_OBJECT_USER)

            if (strJsonUser.isNullOrEmpty()) {
                return null
            }

            try {
                // Desrialization: chuyển string -> obj
                val gson = Gson()
                return gson.fromJson(strJsonUser, User::class.java)
            } catch (e: JsonSyntaxException) {
                // Xử lý trường hợp JSON không đúng định dạng
                e.printStackTrace()
                return null
            }
        }
    }

    private var mySharedPreferences: MySharedPreferences? = null
}