package com.example.globetrotterapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class FlightBookActivity : AppCompatActivity() {

    //private lateinit var fromSpinner: Spinner
    //private lateinit var toSpinner: Spinner
    private lateinit var bookNowButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_book)

        val fromSpinner = intent.getStringExtra("from")?:""
        val toSpinner = intent.getStringExtra("to")?:""
        bookNowButton = findViewById(R.id.viewDetail1)

        bookNowButton.setOnClickListener {
            val fromLocation = fromSpinner
            val toLocation = toSpinner

            val intent = Intent(this, FlightDetailsActivity::class.java).apply {
                putExtra("EXTRA_FROM_LOCATION", fromLocation)
                putExtra("EXTRA_TO_LOCATION", toLocation)
            }
            startActivity(intent)
        }
    }
}
