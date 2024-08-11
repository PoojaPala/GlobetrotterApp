package com.example.globetrotterapp


import android.content.Intent
import android.os.Bundle
import android.widget.Spinner
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class BoardingPassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boarding_pass)


        val seatNumber = intent.getStringExtra("seatNumber")?:""
        val passengerName = intent.getStringExtra("firstName")?:"" // Retrieve this from wherever it was saved
        val gateNumber = "A6"

        // Initialize TextViews
        val seatNumberTextView = findViewById<TextView>(R.id.seatnumber)
        val passengerNameTextView = findViewById<TextView>(R.id.pname)
        val flightFromTextView = findViewById<TextView>(R.id.departureAirport1)
        val flightToTextView = findViewById<TextView>(R.id.arrivalAirport1)
        val gateNumberTextView = findViewById<TextView>(R.id.gatenumber)

        // Set values
        seatNumberTextView.text = seatNumber
        passengerNameTextView.text = passengerName
        flightFromTextView.text = intent.getStringExtra("from")?:""
        flightToTextView.text = intent.getStringExtra("to")?:""
        gateNumberTextView.text = gateNumber

        // Set up click listener for the download button
        val downloadButton = findViewById<Button>(R.id.book)
        downloadButton.setOnClickListener {
            showToast("Your boarding pass is downloaded")
        }

        val mainButton = findViewById<Button>(R.id.BookingPage)
        mainButton.setOnClickListener {
            val intent = Intent(baseContext, MainActivity::class.java)
            intent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent.putExtra("email",getIntent().getStringExtra("email"))
            intent.putExtra("name", getIntent().getStringExtra("name"))
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(baseContext, MainActivity::class.java)
        intent.flags =
            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.putExtra("email",getIntent().getStringExtra("email"))
        intent.putExtra("name", getIntent().getStringExtra("name"))
        startActivity(intent)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
