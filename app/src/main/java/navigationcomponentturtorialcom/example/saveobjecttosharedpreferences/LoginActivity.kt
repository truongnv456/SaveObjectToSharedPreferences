package navigationcomponentturtorialcom.example.saveobjecttosharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import navigationcomponentturtorialcom.example.saveobjecttosharedpreferences.model.User

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val user = User(1, "Truong", "Hoai Duc, Ha Noi")
        DataLocalManager.setUser(user)

        val btnGoToMainScreen = findViewById<Button>(R.id.btn_go_to_main)

        btnGoToMainScreen.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}