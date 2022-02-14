package rene.hernandez.thecheezery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button:Button = findViewById(R.id.button_get_started) as Button

        button.setOnClickListener {
    var intent: Intent = Intent(this, RegistrerActivity:class.java)
                startActivity(intenet)
        }

    }
}