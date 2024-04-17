package com.app.retirementsaving

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etName = findViewById<EditText>(R.id.etName).text
        val etSurname = findViewById<EditText>(R.id.etSurname).text
        val etGender = findViewById<EditText>(R.id.etGender).text
        val etAge = findViewById<EditText>(R.id.etAge).text
        val etYears = findViewById<EditText>(R.id.etYears).text
        val etSalary = findViewById<EditText>(R.id.etSalary).text

        val tvDisplay = findViewById<TextView>(R.id.tvDisplay)

        val btnEstimate = findViewById<Button>(R.id.btnEstimate)

        btnEstimate.setOnClickListener {

            val years = etYears.toString().toInt()

            if (years >= 10 && years <= 20) {

                var intent = Intent(this, SavingSheet::class.java)

                //Sending values
                intent.putExtra("name", etName.toString())
                intent.putExtra("surname", etSurname.toString())
                intent.putExtra("gender", etGender.toString())
                intent.putExtra("years", etYears.toString())
                intent.putExtra("salary", etSalary.toString())
                intent.putExtra("age", etAge.toString())

                startActivity(intent)

            } else {
                tvDisplay.text = "Error: minimum is 10 and maximum is 20"
            }
        }


    }
}