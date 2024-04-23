package com.bevia.bdpsoftwaresolution

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        resultTextView = findViewById(R.id.resultTextView)

        // Get the intent that started this activity
        // in case a onNewIntent() is not called
        val intent = intent
        Log.d("DEBUG_INTENT", "intent $intent")
        // Check if the intent is null
        // retrieve intent extra data including message.
        if (intent != null && intent.hasExtra("status")) {

            //val status = intent.getIntExtra("status", 0)
            //val message = intent.getStringExtra("message") ?: ""

            resultTextView.text = "Result intent via onCreate"

            //call the payment App here
            callPaymentApp()

        }else{
            //TODO: run your default code here
            //Encapsulate your default code in a private method and call it here

            resultTextView.text = "No intent data found"

            Log.d("DEBUG_INTENT", "run your default code here")
        }

        Log.d("DEBUG_INTENT", "onCreate")
        val btnToTableSelection = this.findViewById<Button>(R.id.button_to_table_selection)
                btnToTableSelection.setOnClickListener {
            callNextActivity()
        }

    }

    private fun callNextActivity() {


    }

    private fun callPaymentApp() {


    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("DEBUG_INTENT", "onNewIntent")
        resultTextView.text = "Result intent via onNewIntent"

        //call the payment App here
        callPaymentApp()
    }


    override fun onResume() {
        super.onResume()
        Log.d("DEBUG_INTENT", "onResume")

    }
}