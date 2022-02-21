package rene.hernandez.thecheezery

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btncold.setOnClickListener {startActivity(Intent(this, ProductosActivity::class.java).putExtra("tipoProductos", "coldDrinks")) }
        btnhot.setOnClickListener {startActivity(Intent(this, ProductosActivity::class.java).putExtra("tipoProductos", "hotDrinks")) }
        btnsweets.setOnClickListener {startActivity(Intent(this, ProductosActivity::class.java).putExtra("tipoProductos", "sweets")) }
        btnsalties.setOnClickListener {startActivity(Intent(this, ProductosActivity::class.java).putExtra("tipoProductos", "salties")) }
        btncombos.setOnClickListener {startActivity(Intent(this, CombosActivity::class.java)) }
        btnpersonalized.setOnClickListener {startActivity(Intent(this, ProductosActivity::class.java).putExtra("tipoProductos", "coldDrinks")) }
    }
}
