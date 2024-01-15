package navigationcomponentturtorialcom.example.saveobjecttosharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import navigationcomponentturtorialcom.example.saveobjecttosharedpreferences.model.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvInfo = findViewById<TextView>(R.id.tv_info)
        val user: User? = DataLocalManager.getUser()
        tvInfo.setText(user.toString())
    }
}