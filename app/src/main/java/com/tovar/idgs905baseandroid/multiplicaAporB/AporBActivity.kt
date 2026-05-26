package com.tovar.idgs905baseandroid.multiplicaAporB

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tovar.idgs905baseandroid.R

class AporBActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_apor_bactivity)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnNumeroA = findViewById<EditText>(R.id.btnNumeroA)
        val btnNumeroB = findViewById<EditText>(R.id.btnNumeroB)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            val stringA = btnNumeroA.text.toString()
            val stringB = btnNumeroB.text.toString()

            if (stringA.isEmpty() || stringB.isEmpty()) {
                Toast.makeText(this, "Falta un campo", Toast.LENGTH_SHORT).show()
            } else {
                val numA = stringA.toInt()
                val numB = stringB.toInt()

                val intent = Intent(this, ResultAporBActivity::class.java)
                intent.putExtra("NUMERO_A", numA)
                intent.putExtra("NUMERO_B", numB)
                startActivity(intent)
            }
        }
    }
}