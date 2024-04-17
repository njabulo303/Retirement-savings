package com.app.retirementsaving

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SavingSheet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_saving_sheet)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        //Receiving values
        val bundle: Bundle? = intent.extras

        val name = bundle?.getString("name").toString()
        val surname = bundle?.getString("surname").toString()
        val age: Int = bundle?.getString("age").toString().toInt()
        val gender = bundle?.getString("gender").toString()
        val salary = bundle?.getString("salary").toString().toDouble()
        val years: Int = bundle?.getString("years").toString().toInt()

        tvGreeting.text = "Hi $name $surname, here is the breakdown of your retirement savings"

        var deduction = 0.0
        var total = 0.0
        var output = ""
        var counter = 1

        while (counter <= years) {

            if (counter % 2 == 1) {
                deduction = salary * 7.5 / 100
            } else {
                deduction = salary * 7.75 / 100
            }
            total += deduction
            output += "Year $counter = R $deduction \n"
            counter++
        }

        output += "\nTotal = R $total"

        tvResult.text = output

    }
}