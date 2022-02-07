package rene.hernandez.asignacion04_calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class resultado : AppCompatActivity() {
    TextView TxResultado;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        TxResultado = (TextView) findViewById(R.TV_Resultado)

        Intent i = getIntent()
        double altura = i.getDoubleExtra("altura",0)
        double peso = i.getDoubleExtra("peso",0)
        double imc = (peso/Math.pow(altura,2))
        TxResultado.setText(String.valueOf(imc));


    }

    public void volverOnClick(View v){
        super.onBackPressed();
    }
}