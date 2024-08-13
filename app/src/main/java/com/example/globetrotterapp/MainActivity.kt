package com.example.globetrotterapp


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var bookButton: Button
    private lateinit var disneyButton: ImageButton
    private lateinit var maldivesButton: ImageButton
    private lateinit var turkeyButton: ImageButton
    private lateinit var parisButton: ImageButton
    private lateinit var niagaraButton: ImageButton
    private lateinit var nyButton: ImageButton
    private lateinit var indiaButton: ImageButton
    private lateinit var welcomeBanner: TextView
    private lateinit var dessertListText: TextView
    private lateinit var recommendedPackagesText: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        bookButton = findViewById(R.id.book)

//        disneyButton = findViewById(R.id.disney)
//        maldivesButton = findViewById(R.id.maldives)
//        turkeyButton = findViewById(R.id.turkey)
//        parisButton = findViewById(R.id.paris)
//        niagaraButton = findViewById(R.id.niagara)
//        nyButton = findViewById(R.id.ny)
//        indiaButton = findViewById(R.id.india)
          welcomeBanner= findViewById(R.id.welcome)
        findViewById<Button>(R.id.MyBooking).setOnClickListener{
            var intent = Intent(this, BookingDetailsList::class.java)
            intent.putExtra("email",getIntent().getStringExtra("email"))
            intent.putExtra("name", getIntent().getStringExtra("name"))
            startActivity(intent)
        }

//        dessertListText = findViewById(R.id.dessert_list)
//        recommendedPackagesText = findViewById(R.id.textView4)

        welcomeBanner.text = "Welcome "+ intent.getStringExtra("name")
        // Set up click listeners
        bookButton.setOnClickListener {
            // Handle book button click
            val intent = Intent(this, TravelActivity::class.java)
            intent.putExtra("email",getIntent().getStringExtra("email"))
            intent.putExtra("name", getIntent().getStringExtra("name"))
            startActivity(intent)
        }

//        disneyButton.setOnClickListener {
//            // Handle Disney button click
//            // Add functionality or show a toast message
//        }
//
//        maldivesButton.setOnClickListener {
//            // Handle Maldives button click
//            // Add functionality or show a toast message
//        }
//
//        turkeyButton.setOnClickListener {
//            // Handle Turkey button click
//            // Add functionality or show a toast message
//        }
//
//        parisButton.setOnClickListener {
//            // Handle Paris button click
//            // Add functionality or show a toast message
//        }
//
//        niagaraButton.setOnClickListener {
//            // Handle Niagara button click
//            // Add functionality or show a toast message
//        }
//
//        nyButton.setOnClickListener {
//            // Handle New York button click
//            // Add functionality or show a toast message
//        }
//
//        indiaButton.setOnClickListener {
//            // Handle India button click
//            // Add functionality or show a toast message
//        }
    }
}
