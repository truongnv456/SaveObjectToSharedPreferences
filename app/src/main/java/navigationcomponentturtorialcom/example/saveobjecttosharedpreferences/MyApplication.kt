package navigationcomponentturtorialcom.example.saveobjecttosharedpreferences

import android.app.Application

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        DataLocalManager.init(applicationContext)
    }
}