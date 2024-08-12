package com.example.globetrotterapp

import android.os.Bundle
import android.widget.Spinner
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textfield.TextInputEditText

class FlightBookActivity : AppCompatActivity() {


    private lateinit var cardView1: CardView
    private lateinit var cardView2: CardView
    private lateinit var cardView3: CardView
    private lateinit var cardView4: CardView

    private lateinit var departureAirport1: TextView
    private lateinit var arrivalAirport1: TextView
    private lateinit var flightDuration1: TextView
    private lateinit var departureTime1: TextView
    private lateinit var arrivalTime1: TextView
    private lateinit var cost1: TextView
    private lateinit var viewDetail1: Button
    private lateinit var planeIcon1: AppCompatImageView

    private lateinit var departureAirport2: TextView
    private lateinit var arrivalAirport2: TextView
    private lateinit var flightDuration2: TextView
    private lateinit var departureTime2: TextView
    private lateinit var arrivalTime2: TextView
    private lateinit var cost2: TextView
    private lateinit var viewDetail2: Button
    private lateinit var planeIcon2: AppCompatImageView

    private lateinit var departureAirport3: TextView
    private lateinit var arrivalAirport3: TextView
    private lateinit var flightDuration3: TextView
    private lateinit var departureTime3: TextView
    private lateinit var arrivalTime3: TextView
    private lateinit var cost3: TextView
    private lateinit var viewDetail3: Button
    private lateinit var planeIcon3: AppCompatImageView

    private lateinit var departureAirport4: TextView
    private lateinit var arrivalAirport4: TextView
    private lateinit var flightDuration4: TextView
    private lateinit var departureTime4: TextView
    private lateinit var arrivalTime4: TextView
    private lateinit var cost4: TextView
    private lateinit var viewDetail4: Button
    private lateinit var planeIcon4: AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_book)

        // Initialize CardViews
        cardView1 = findViewById(R.id.cardView1)
        cardView2 = findViewById(R.id.cardView2)
        cardView3 = findViewById(R.id.cardView3)
        cardView4 = findViewById(R.id.cardView4)

        // Initialize TextViews and Buttons for CardView 1
        departureAirport1 = findViewById(R.id.departureAirport1)
        arrivalAirport1 = findViewById(R.id.arrivalAirport1)
        flightDuration1 = findViewById(R.id.flightDuration1)
        departureTime1 = findViewById(R.id.departureTime1)
        arrivalTime1 = findViewById(R.id.arrivalTime1)
        cost1 = findViewById(R.id.cost1)
        viewDetail1 = findViewById(R.id.viewDetail1)
        planeIcon1 = findViewById(R.id.planeIcon1)

        // Initialize TextViews and Buttons for CardView 2
        departureAirport2 = findViewById(R.id.departureAirport2)
        arrivalAirport2 = findViewById(R.id.arrivalAirport2)
        flightDuration2 = findViewById(R.id.flightDuration2)
        departureTime2 = findViewById(R.id.departureTime2)
        arrivalTime2 = findViewById(R.id.arrivalTime2)
        cost2 = findViewById(R.id.cost2)
        viewDetail2 = findViewById(R.id.viewDetail2)
        planeIcon2 = findViewById(R.id.planeIcon2)

        // Initialize TextViews and Buttons for CardView 3
        departureAirport3 = findViewById(R.id.departureAirport3)
        arrivalAirport3 = findViewById(R.id.arrivalAirport3)
        flightDuration3 = findViewById(R.id.flightDuration3)
        departureTime3 = findViewById(R.id.departureTime3)
        arrivalTime3 = findViewById(R.id.arrivalTime3)
        cost3 = findViewById(R.id.cost3)
        viewDetail3 = findViewById(R.id.viewDetail3)
        planeIcon3 = findViewById(R.id.planeIcon3)

        // Initialize TextViews and Buttons for CardView 4
        departureAirport4 = findViewById(R.id.departureAirport4)
        arrivalAirport4 = findViewById(R.id.arrivalAirport4)
        flightDuration4 = findViewById(R.id.flightDuration4)
        departureTime4 = findViewById(R.id.departureTime4)
        arrivalTime4 = findViewById(R.id.arrivalTime4)
        cost4 = findViewById(R.id.cost4)
        viewDetail4 = findViewById(R.id.viewDetail4)
        planeIcon4 = findViewById(R.id.planeIcon4)

        val from = intent.getStringExtra("from")?:""
        val to = intent.getStringExtra("to")?:""
        val firstName = intent.getStringExtra("firstName")?:""
        departureAirport1.text = from
        arrivalAirport1.text = to

        // Handle button clicks
        viewDetail1.setOnClickListener {

            val fromLocation = from
           val toLocation = to

            val intent = Intent(this, FlightDetailsActivity::class.java).apply {
                putExtra("from", fromLocation)
                putExtra("to", toLocation)
                putExtra("firstName", firstName)
                putExtra("email", intent.getStringExtra("email"))
                putExtra("name", intent.getStringExtra("name"))

        }
            startActivity(intent)
        }
        val froma = intent.getStringExtra("from")?:""
        val tob = intent.getStringExtra("to")?:""
        val firstNamea = intent.getStringExtra("firstName")?:""
        departureAirport2.text = from
        arrivalAirport2.text = to

        viewDetail2.setOnClickListener {
            val fromLocation = froma
            val toLocation = tob
            // Handle click event for Book button in CardView 2
            val intent = Intent(this, FlightDetailsActivity::class.java).apply {
                putExtra("from", fromLocation)
                putExtra("to", toLocation)
                putExtra("firstName", firstNamea)
                putExtra("email", intent.getStringExtra("email"))
                putExtra("name", intent.getStringExtra("name"))

            }
            startActivity(intent)
        }

        val fromc = intent.getStringExtra("from")?:""
        val tod = intent.getStringExtra("to")?:""
        val firstNamec = intent.getStringExtra("firstName")?:""
        departureAirport3.text = fromc
        arrivalAirport3.text = tod

        viewDetail3.setOnClickListener {
            val fromLocation = from
            val toLocation = to

            val intent = Intent(this, FlightDetailsActivity::class.java).apply {
                putExtra("from", fromLocation)
                putExtra("to", toLocation)
                putExtra("firstName", firstNamec)
                putExtra("email", intent.getStringExtra("email"))
                putExtra("name", intent.getStringExtra("name"))

            }
            startActivity(intent)
        }

        val frome = intent.getStringExtra("from")?:""
        val tof = intent.getStringExtra("to")?:""
        val firstNamee = intent.getStringExtra("firstName")?:""
        departureAirport4.text = from
        arrivalAirport4.text = to

        viewDetail4.setOnClickListener {
            // Handle click event for Book button in CardView 4
            val fromLocation = from
            val toLocation = to

            val intent = Intent(this, FlightDetailsActivity::class.java).apply {
                putExtra("from", fromLocation)
                putExtra("to", toLocation)
                putExtra("firstName", firstNamee)
                putExtra("name", intent.getStringExtra("name"))
                putExtra("email", intent.getStringExtra("email"))
            }
            startActivity(intent)
        }
        }

    }



