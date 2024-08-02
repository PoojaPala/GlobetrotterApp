package com.example.globetrotterapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardView: CardView = findViewById(R.id.cardView)
        val bookButton: Button = findViewById(R.id.book)
        val parisButton: ImageButton = findViewById(R.id.paris)
        val niagaraButton: ImageButton = findViewById(R.id.niagara)
        val nyButton: ImageButton = findViewById(R.id.ny)
        val indiaButton: ImageButton = findViewById(R.id.india)
        val maldivesButton: ImageButton = findViewById(R.id.maldives)
        val disneyButton: ImageButton = findViewById(R.id.disney)
        val turkeyButton: ImageButton = findViewById(R.id.turkey)

        parisButton.setOnClickListener { navigateToDestination("Paris") }
        niagaraButton.setOnClickListener { navigateToDestination("Niagara") }
        nyButton.setOnClickListener { navigateToDestination("New York") }
        indiaButton.setOnClickListener { navigateToDestination("Delhi") }
        maldivesButton.setOnClickListener { navigateToDestination("Maldives") }
        disneyButton.setOnClickListener { navigateToDestination("Disneyland") }
        turkeyButton.setOnClickListener { navigateToDestination("Turkey") }

        cardView.setOnClickListener { navigateToBooking() }
        bookButton.setOnClickListener { navigateToBooking() }
    }

    private fun navigateToBooking() {
        val intent = Intent(this, FlightBookActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToDestination(destination: String) {
        val intent = Intent(this, TravelActivity::class.java)
        intent.putExtra("DESTINATION_NAME", destination)
        startActivity(intent)
    }
}
