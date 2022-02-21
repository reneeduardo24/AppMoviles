package rene.hernandez.thecheezery

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_productos.*
import kotlinx.android.synthetic.main.producto_view.view.*

class ProductosActivity : AppCompatActivity() {

    var coldDrinks = ArrayList<Producto>()
    var hotDrinks = ArrayList<Producto>()
    var sweets = ArrayList<Producto>()
    var salties = ArrayList<Producto>()
    var adaptador : AdaptadorProducto? =  null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        btnback.setOnClickListener { startActivity(Intent(this,MenuActivity::class.java)) }


        var bundle = intent.extras
        if(bundle != null){
            //Toast.makeText(this,bundle.getString("tipoProductos"), Toast.LENGTH_SHORT ).show()

            when(bundle.getString("tipoProductos")){
                "hotDrinks"-> {
                    cargarHotDrinks()
                    adaptador = AdaptadorProducto(this, hotDrinks)
                    headerProductos.setImageResource(R.drawable.hotdrinks)
                }
                "coldDrinks"-> {
                    cargarColdDrinks()
                    adaptador = AdaptadorProducto(this, coldDrinks)
                    headerProductos.setImageResource(R.drawable.colddrinks)
                }
                "sweets"-> {
                    cargarSweets()
                    adaptador = AdaptadorProducto(this, sweets)
                    headerProductos.setImageResource(R.drawable.sweets)
                }
                "salties"-> {
                    cargarSalties()
                    adaptador = AdaptadorProducto(this, salties)
                    headerProductos.setImageResource(R.drawable.salties)
                }
                else ->{
                    cargarColdDrinks()
                    adaptador = AdaptadorProducto(this, coldDrinks)
                    headerProductos.setImageResource(R.drawable.colddrinks)
                }
            }
        }

        listaProductos.adapter = adaptador

    }




    fun cargarColdDrinks(){
        coldDrinks.add(Producto("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5))
        coldDrinks.add(Producto("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6))
        coldDrinks.add(Producto("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3))
        coldDrinks.add(Producto("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4))
        coldDrinks.add(Producto("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7))
        coldDrinks.add(Producto("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7))
    }

    fun cargarHotDrinks(){
        hotDrinks.add(Producto("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6))
        hotDrinks.add(Producto("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5))
        hotDrinks.add(Producto("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4))
        hotDrinks.add(Producto("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6))
        hotDrinks.add(Producto("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7))
        hotDrinks.add(Producto("American coffee", R.drawable.americano, "Espresso with hot water", 2))
    }
    fun cargarSweets(){
        sweets.add(Producto("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped with cheese topping and blueberries.", 6))
        sweets.add(Producto("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries", 3))
        sweets.add(Producto("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemon flavored filling", 4))
        sweets.add(Producto("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6))
        sweets.add(Producto("Cherry cheesecake", R.drawable. strawberrycheesecake, "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7))
        sweets.add(Producto("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6))
    }

    fun cargarSalties(){
        salties.add(Producto("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6))
        salties.add(Producto("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5))
        salties.add(Producto("Panini", R.drawable.hampanini, "Sandwich made with Italian bread  served warmed by grilling.", 4))
        salties.add(Producto("Philly cheese steak", R.drawable. phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6))
        salties.add(Producto("Nachos", R.drawable. nachos, "Tortilla chips layered with beef and   melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.",  7))
    }
}



class AdaptadorProducto: BaseAdapter {

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