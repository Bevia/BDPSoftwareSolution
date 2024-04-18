package com.bevia.bdpsoftwaresolution

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TableSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_table_selection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        this.onBackPressedDispatcher.addCallback(this, callback)

        val btnToTable = findViewById<Button>(R.id.button_to_table)
        btnToTable.setOnClickListener {
            callNextActivity()
        }

        val btnBack= findViewById<Button>(R.id.back_to_main)
        btnBack.setOnClickListener {
            callCallerActivity()
        }
    }

    private fun callNextActivity() {
        val intent = Intent(this, Table::class.java)
        startActivity(intent)

    }

    private fun callCallerActivity(){
        //Note: FLAG_ACTIVITY_CLEAR_TOP is used to clear the back stack of the caller activity
        //if you do finish() the caller activity will be destroyed and onNewIntent() will not be called
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
    }

    private val callback = object : OnBackPressedCallback(true /* enabled by default */) {
        override fun handleOnBackPressed() {
            // Handle back navigation as needed
            // If needed, set appropriate flags to ensure onNewIntent() is called in CallerActivity
            callCallerActivity()

        }
    }
}