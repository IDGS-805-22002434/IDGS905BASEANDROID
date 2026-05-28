package com.tovar.idgs905baseandroid.examenResistencia

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tovar.idgs905baseandroid.R
import kotlin.math.pow

class ExamenActivity : AppCompatActivity() {

    private val codigosColor = arrayOf(
        "#000000",
        "#8B4513",
        "#F44336",
        "#FF9800",
        "#FFEB3B",
        "#4CAF50",
        "#2196F3",
        "#9C27B0",
        "#9E9E9E",
        "#FFFFFF"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_examen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spBanda1 = findViewById<Spinner>(R.id.spBanda1)
        val spBanda2 = findViewById<Spinner>(R.id.spBanda2)
        val spMultiplicador = findViewById<Spinner>(R.id.spMultiplicador)

        val rgTolerancia = findViewById<RadioGroup>(R.id.rgTolerancia)
        val rbOro = findViewById<RadioButton>(R.id.rbOro)

        val tvBanda1 = findViewById<TextView>(R.id.tvBanda1)
        val tvBanda2 = findViewById<TextView>(R.id.tvBanda2)
        val tvMultiplicador = findViewById<TextView>(R.id.tvMultiplicador)
        val tvTolerancia = findViewById<TextView>(R.id.tvTolerancia)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultadoOhm = findViewById<TextView>(R.id.tvResultadoOhm)
        val tvResultadoMaximo = findViewById<TextView>(R.id.tvResultadoMaximo)
        val tvResultadoMinimo = findViewById<TextView>(R.id.tvResultadoMinimo)

        val colores = arrayOf("Negro", "Café", "Rojo", "Naranja", "Amarillo", "Verde", "Azul", "Violeta", "Gris", "Blanco")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, colores)

        spBanda1.adapter = adapter
        spBanda2.adapter = adapter
        spMultiplicador.adapter = adapter

        spBanda1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                actualizarCaja(tvBanda1, position, false)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spBanda2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                actualizarCaja(tvBanda2, position, false)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spMultiplicador.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                actualizarCaja(tvMultiplicador, position, true)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        rgTolerancia.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.rbOro) {
                tvTolerancia.setBackgroundColor(Color.parseColor("#FFC107"))
                tvTolerancia.text = "5%"
            } else {
                tvTolerancia.setBackgroundColor(Color.parseColor("#E0E0E0"))
                tvTolerancia.text = "10%"
            }
        }

        spBanda1.setSelection(2)
        spBanda2.setSelection(2)
        spMultiplicador.setSelection(1)

        btnCalcular.setOnClickListener {
            val val1 = spBanda1.selectedItemPosition
            val val2 = spBanda2.selectedItemPosition
            val multIndex = spMultiplicador.selectedItemPosition

            val multiplierValue = 10.0.pow(multIndex.toDouble()).toLong()
            val base = (val1 * 10) + val2
            val ohms = base * multiplierValue

            val tolerancePercent = if (rbOro.isChecked) 0.05 else 0.10
            val toleranceValue = ohms * tolerancePercent

            val max = ohms + toleranceValue
            val min = ohms - toleranceValue

            tvResultadoOhm.text = ohms.toString()
            tvResultadoMaximo.text = max.toString()
            tvResultadoMinimo.text = min.toString()
        }
    }

    private fun actualizarCaja(tv: TextView, position: Int, esMultiplicador: Boolean) {
        tv.setBackgroundColor(Color.parseColor(codigosColor[position]))

        if (position == 4 || position == 9) {
            tv.setTextColor(Color.BLACK)
        } else {
            tv.setTextColor(Color.WHITE)
        }

        if (esMultiplicador) {
            val multiplierValue = 10.0.pow(position.toDouble()).toLong()
            tv.text = multiplierValue.toString()
        } else {
            tv.text = position.toString()
        }
    }
}