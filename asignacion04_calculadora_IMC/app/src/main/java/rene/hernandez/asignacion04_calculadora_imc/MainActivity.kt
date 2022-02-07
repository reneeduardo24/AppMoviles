package rene.hernandez.asignacion04_calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    //variables
    EditText ET_Peso, ET_Altura;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ET_Peso = (EditText) findViewById(R.id.ET_Peso);
        ET_Altura = (EditText) findViewById(R.id.ET_Altura);
        //evento boton
    }
    //funcion
    public void CalcularOnClick(View v){
        try{
            double peso = Double.parseDouble(ET_Peso.getText().toString())
            double altura = Double.parseDouble(ET_Altura.getText().toString())

            Intent i = new Intent(this, Resultado.class)
                    i.putExtra("peso", peso)
            i.putExtra("Altura", altura)

            startActivity(i)
        }catch(Exception e){
        Toast.makeText(this, "Error al ingresar datos", toast.LENGHT_SHORT).show()


        }

    }
}