package rene.hernandez.thecheezery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val button:Button = findViewById(R.id.sing_in_button) as Button

        button.setOnClickListener {
            var intent: Intent = Intent(this, MenuActivity:class.java)
            startActivity(intent)
        }
    }
}