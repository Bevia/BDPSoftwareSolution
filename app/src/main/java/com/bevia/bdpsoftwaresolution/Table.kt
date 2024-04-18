package com.bevia.bdpsoftwaresolution

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Table : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_table)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnToPaymentSelection = findViewById<Button>(R.id.button_to_payment)
        btnToPaymentSelection.setOnClickListener {
            callNextActivity()
        }

        val btnBack = findViewById<Button>(R.id.back_to_table_selection)
        btnBack.setOnClickListener {
            callCallerActivity()
        }
    }

    private fun callNextActivity() {
        val intent = Intent(this, PaymentSelection::class.java)
        startActivity(intent)

    }

    private fun callCallerActivity() {
        finish()
    }

    private val callback = object : OnBackPressedCallback(true /* enabled by default */) {
        override fun handleOnBackPressed() {
            callCallerActivity()

        }
    }
}