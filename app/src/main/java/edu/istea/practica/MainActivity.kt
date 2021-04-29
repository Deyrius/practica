package edu.istea.practica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    lateinit var nombre: EditText
    lateinit var raza:EditText
    lateinit var edad:Number
    lateinit var causa:EditText
    lateinit var agregar:Button
    lateinit var gato:CheckBox
    lateinit var perro:CheckBox
    lateinit var conejo:CheckBox
    lateinit var tipo:String
    lateinit var juan:Button
    lateinit var pedro:Button
    val listaAnimales : ArrayList<Animal> = ArrayList<Animal>()
    var contadorAnimales by Delegates.notNull<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarElementos()



        agregar.setOnClickListener(View.OnClickListener {
            if(gato.isChecked && contadorAnimales< 5){
                tipo = gato.text.toString()
                var animal = cargoAnimal(tipo)
                listaAnimales.add(animal)
                cleanElements()
                Toast.makeText(this,"Se agrego un Gato",Toast.LENGTH_SHORT).show()
                contadorAnimales++
            }
            if(perro.isChecked && contadorAnimales< 5){
                tipo = perro.text.toString()
                var animal = cargoAnimal(tipo)
                listaAnimales.add(animal)
                cleanElements()
                Toast.makeText(this,"Se agrego un Perro",Toast.LENGTH_SHORT).show()
                contadorAnimales++
            }
            if(conejo.isChecked && contadorAnimales< 5){
                tipo = conejo.text.toString()
                var animal = cargoAnimal(tipo)
                listaAnimales.add(animal)
                cleanElements()
                Toast.makeText(this,"Se agrego un Conejo",Toast.LENGTH_SHORT).show()
                contadorAnimales++
            }
            if(contadorAnimales == 5){
                Toast.makeText(this,"No hay mas cupo para animales.",Toast.LENGTH_LONG).show()
            }

        })

        juan.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,JuanVete::class.java)
            intent.putExtra("listaAnimales",listaAnimales)
            startActivity(intent)
        })
        pedro.setOnClickListener { View.OnClickListener {
            val intent = Intent(this,PedroVete::class.java)
            intent.putExtra("listaAnimales",listaAnimales)
            startActivity(intent)
        } }


    }
    private fun cargoAnimal(tipo:String):Animal{

        return Animal(nombre.text.toString(),
                    raza.text.toString(),
                    tipo,
                    edad.toInt(),
                    causa.text.toString())

    }


    private fun inicializarElementos(){
        gato = findViewById(R.id.chk_gato)
        perro = findViewById(R.id.chk_perro)
        conejo = findViewById(R.id.chk_conejo)
        agregar = findViewById(R.id.btn_agregar)
        nombre = findViewById(R.id.txt_p_v_diagnostico)
        raza = findViewById(R.id.txt_raza)
        edad = findViewById(R.id.txt_edad)
        causa = findViewById(R.id.txt_atencion)
        tipo = ""
        contadorAnimales = 0
        pedro = findViewById(R.id.btn_pedro)
        juan = findViewById(R.id.btn_juan)
    }

    private fun cleanElements(){
        nombre.setText("")
        raza.setText("")
        edad = 0
        causa.setText("")

    }

}