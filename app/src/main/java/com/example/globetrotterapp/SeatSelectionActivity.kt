package com.example.globetrotterapp


import android.widget.Toast
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SeatSelectionActivity : AppCompatActivity() {

    private var selectedSeat: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection) // Replace with your actual XML layout name

        // Initialize buttons
        val button1A = findViewById<Button>(R.id.onea)
        val button1K = findViewById<Button>(R.id.onek)
        val button2A = findViewById<Button>(R.id.twoa)
        val button2C = findViewById<Button>(R.id.twoc)
        val button2D = findViewById<Button>(R.id.twod)
        val button2F = findViewById<Button>(R.id.twof)
        val button3C = findViewById<Button>(R.id.threec)
        val button3D = findViewById<Button>(R.id.threed)
        val button3F = findViewById<Button>(R.id.threef)
        val button4A = findViewById<Button>(R.id.foura)
        val button4B = findViewById<Button>(R.id.fourb)
        val button4C = findViewById<Button>(R.id.fourc)
        val button4D = findViewById<Button>(R.id.fourd)
        val button4E = findViewById<Button>(R.id.foure)
        val button4F = findViewById<Button>(R.id.fourf)
        val button5A = findViewById<Button>(R.id.fivea)
        val button5B = findViewById<Button>(R.id.fiveb)
        val button5C = findViewById<Button>(R.id.fivec)
        val button5D = findViewById<Button>(R.id.fived)
        val button5E = findViewById<Button>(R.id.fivee)
        val button5F = findViewById<Button>(R.id.fivef)
        val button6A = findViewById<Button>(R.id.sixa)
        val button6C = findViewById<Button>(R.id.sixc)
        val button6D = findViewById<Button>(R.id.sixd)
        val button6E = findViewById<Button>(R.id.sixe)
        val button6F = findViewById<Button>(R.id.sixf)
        val confirmButton = findViewById<Button>(R.id.book)

        // Set up click listeners for the buttons
        button1A.setOnClickListener {
            showToast("This seat is reserved. Please select another seat")
        }

        button1K.setOnClickListener {
            selectSeat("1K")
        }

        button2A.setOnClickListener {
            selectSeat("2A")
        }

        button2C.setOnClickListener {
            selectSeat("2C")
        }

        button2D.setOnClickListener {
            showToast("This seat is reserved. Please select another seat")
        }

        button2F.setOnClickListener {
            selectSeat("2F")
        }

        button3C.setOnClickListener {
            selectSeat("3C")
        }

        button3D.setOnClickListener {
            selectSeat("3D")
        }

        button3F.setOnClickListener {
            showToast("This seat is reserved. Please select another seat")
        }

        button4A.setOnClickListener {
            selectSeat("4A")
        }

        button4B.setOnClickListener {
            selectSeat("4B")
        }

        button4C.setOnClickListener {
            selectSeat("4C")
        }

        button4D.setOnClickListener {
            selectSeat("4D")
        }

        button4E.setOnClickListener {
            selectSeat("4E")
        }

        button4F.setOnClickListener {
            selectSeat("4F")
        }

        button5A.setOnClickListener {
            selectSeat("5A")
        }

        button5B.setOnClickListener {
            selectSeat("5B")
        }

        button5C.setOnClickListener {
            selectSeat("5C")
        }

        button5D.setOnClickListener {
            showToast("This seat is reserved. Please select another seat")
        }

        button5E.setOnClickListener {
            showToast("This seat is reserved. Please select another seat")
        }

        button5F.setOnClickListener {
            selectSeat("5F")
        }

        button6A.setOnClickListener {
            selectSeat("6A")
        }

        button6C.setOnClickListener {
            selectSeat("6C")
        }

        button6D.setOnClickListener {
            selectSeat("6D")
        }

        button6E.setOnClickListener {
            selectSeat("6E")
        }

        button6F.setOnClickListener {
            selectSeat("6F")
        }

        confirmButton.setOnClickListener {
            if (selectedSeat != null) {
                navigateToNextActivity(selectedSeat!!)
            } else {
                showToast("Please select a seat")
            }
        }
    }

    private fun selectSeat(seatNumber: String) {
        selectedSeat = seatNumber
        showToast("Selected seat: $seatNumber")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToNextActivity(seatNumber: String) {
        val intent = Intent(this, BoardingPassActivity::class.java)
        intent.putExtra("SEAT_NUMBER", seatNumber)
        startActivity(intent)
    }
}
