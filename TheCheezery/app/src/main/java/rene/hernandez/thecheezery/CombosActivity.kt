package rene.hernandez.thecheezery

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_combos.*
import kotlinx.android.synthetic.main.producto_view.view.*

class CombosActivity : AppCompatActivity() {

    var combos = ArrayList<Producto>()
    var adaptador : AdaptadorProductoGrid? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combos)

        btnback.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        cargarCombos()
        adaptador = AdaptadorProductoGrid(this, combos)
        gridcombos.adapter = adaptador
    }

    fun cargarCombos(){
        combos.add(Producto("Donut & Coffee", R.drawable.coffedonut, "A finely baked donut with a cup of our fresh hot coffee.", 12))
        combos.add(Producto("Chocolate cake & milk", R.drawable.cakemilk, "A slice of our sweet chocolate cake with a glass of fresh milk.", 13))
        combos.add(Producto("Bagel & Coffee", R.drawable.coffebagel, "A cup of dark coffee served with a classic stuffed bagel.", 11))
        combos.add(Producto("Cookies & Hot Chocolate", R.drawable.chocolatecookies, "The lovely combination of cookies and hot chocolate with tiny marshmellows.", 9))
        combos.add(Producto("Pannini & Frappe", R.drawable.paninifrappe, "Quality bread pannini served with a caramel frappe.", 14))

    }
}



class AdaptadorProductoGrid: BaseAdapter {

    var productos = ArrayList<Producto>()
    var contexto: Context? = null

    constructor(contexto: Context, productos: ArrayList<Producto>){
        this.contexto = contexto
        this.productos = productos
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var producto = productos[position]
        var inflator = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflator.inflate(R.layout.producto_view, null)

        vista.imgProducto.setImageResource(producto.img)
        vista.titleProducto.setText(producto.name)
        vista.descProducto.setText(producto.description)
        vista.precioProducto.setText("$${producto.precio}")

        return vista
    }

    override fun getItem(position: Int): Any {
        return productos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return productos.size
    }

}