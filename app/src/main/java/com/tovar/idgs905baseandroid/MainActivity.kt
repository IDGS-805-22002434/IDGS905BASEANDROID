package com.tovar.idgs905baseandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tovar.idgs905baseandroid.Ejemplo1.ejemplo1
import com.tovar.idgs905baseandroid.Ejemplo2.Ejemplo2Activity
import com.tovar.idgs905baseandroid.Ejemplo3.Ejemplo3Activity
import com.tovar.idgs905baseandroid.distanciaentredospuntos.distanciaentredospuntos
import com.tovar.idgs905baseandroid.multiplicaAporB.AporBActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnEjemplo1 = findViewById<Button>(R.id.btn1)
        val btnEjemplo2 = findViewById<Button>(R.id.btn3)
        val btndistanciaentredospuntos = findViewById<Button>(R.id.btn2)
        val btnAporB = findViewById<Button>(R.id.btnAporB)
        val btnEjemplo3 = findViewById<Button>(R.id.btn4)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnEjemplo1.setOnClickListener { navegateToEjemplo1() }
        btnEjemplo2.setOnClickListener { navegateToEjemplo2() }
        btndistanciaentredospuntos.setOnClickListener { navegateTodistanciaentredospuntos() }
        btnAporB.setOnClickListener { navigateToAporB() }
        btnEjemplo3.setOnClickListener { navegateToEjemplo3() }

    }

    fun navegateToEjemplo1(){
        val intent = Intent(this, ejemplo1::class.java)
        startActivity(intent)
    }
    fun navegateTodistanciaentredospuntos(){
        val intent = Intent(this, distanciaentredospuntos::class.java)
        startActivity(intent)
    }

    fun navegateToEjemplo2(){
        val intent = Intent(this, Ejemplo2Activity::class.java)
        startActivity(intent)
    }

    fun navigateToAporB(){
        val intent = Intent(this, AporBActivity::class.java)
        startActivity(intent)
    }

    fun navegateToEjemplo3(){
        val intent = Intent(this, Ejemplo3Activity::class.java)
        startActivity(intent)
    }
}