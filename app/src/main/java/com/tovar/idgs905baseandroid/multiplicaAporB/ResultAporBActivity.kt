package com.tovar.idgs905baseandroid.multiplicaAporB

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tovar.idgs905baseandroid.R

class ResultAporBActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_apor_bactivity)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvOperacionYResultado = findViewById<TextView>(R.id.tvOperacionYResultado)

        val numA = intent.getIntExtra("NUMERO_A", 0)
        val numB = intent.getIntExtra("NUMERO_B", 0)

        val resultadoFinal = numA * numB

        var desglose = ""

        if (numB <= 0) {
            desglose = "0 = 0"
        } else {
            var cadenaSumas = ""
            for (i in 1..numB) {
                cadenaSumas = cadenaSumas + numA.toString()

                if (i < numB) {
                    cadenaSumas = cadenaSumas + " + "
                }
            }
            desglose = "$cadenaSumas = $resultadoFinal"
        }

        tvOperacionYResultado.text = desglose
    }
}