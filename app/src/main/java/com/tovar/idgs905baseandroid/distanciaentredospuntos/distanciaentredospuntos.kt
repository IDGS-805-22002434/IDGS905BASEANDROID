package com.tovar.idgs905baseandroid.distanciaentredospuntos

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tovar.idgs905baseandroid.R
import kotlin.math.pow
import kotlin.math.sqrt

class distanciaentredospuntos : AppCompatActivity() {
    lateinit var edtX1: EditText
    lateinit var edtY1: EditText
    lateinit var edtX2: EditText
    lateinit var edtY2: EditText
    lateinit var btnCalcular: Button
    lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distanciaentredospuntos)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edtX1 = findViewById(R.id.edtX1)
        edtY1 = findViewById(R.id.edtY1)
        edtX2 = findViewById(R.id.edtX2)
        edtY2 = findViewById(R.id.edtY2)
        btnCalcular = findViewById(R.id.btnCalcular)
        txtResultado = findViewById(R.id.txtResultado)

        btnCalcular.setOnClickListener {
            if (edtX1.text.isNotEmpty() && edtY1.text.isNotEmpty() &&
                edtX2.text.isNotEmpty() && edtY2.text.isNotEmpty()) {

                val x1 = edtX1.text.toString().toDouble()
                val y1 = edtY1.text.toString().toDouble()
                val x2 = edtX2.text.toString().toDouble()
                val y2 = edtY2.text.toString().toDouble()

                val distancia = calcularDistancia(x1, y1, x2, y2)

                txtResultado.text = String.format("Distancia: %.2f", distancia)
            } else {
                txtResultado.text = "Hace falta un campo"
            }
        }
    }

    fun calcularDistancia(x1: Double, y1: Double, x2: Double, y2: Double): Double {
        return sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))
    }
}