package edu.istea.practica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.*
import kotlin.properties.Delegates



class JuanVete : AppCompatActivity(){

    lateinit var diagnostico: EditText
    lateinit var causas:EditText
    lateinit var medicamentos:EditText
    lateinit var tratamiento:EditText
    lateinit var reposo:EditText




    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.juan_vete)
        inicializarElementos()








    }
    private fun inicializarElementos(){
        diagnostico = findViewById(R.id.txt_j_v_diagnostico)
        causas = findViewById(R.id.txt_j_v_causas)
        medicamentos = findViewById(R.id.txt_j_v_medicamentos)
        tratamiento = findViewById(R.id.txt_j_v_tratamientos)
        reposo = findViewById(R.id.txt_j_v_reposo)

    }

    private fun creoSpinnerLayout(){

        var adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,roles)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spRol.adapter = adapter
    }
}