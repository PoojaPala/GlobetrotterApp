package com.example.globetrotterapp

import android.widget.Toast
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SeatSelectionActivity : AppCompatActivity() {

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
            showToast("This seat is reserved.Please select another seat")
        }

        button1K.setOnClickListener {
            navigateToNextActivity()
        }

        button2A.setOnClickListener {
            navigateToNextActivity()
        }

        button2C.setOnClickListener {
            navigateToNextActivity()
        }

        button2D.setOnClickListener {
            showToast("This seat is reserved.Please select another seat")
        }

        button2F.setOnClickListener {
            navigateToNextActivity()
        }



        button3C.setOnClickListener {
            navigateToNextActivity()
        }

        button3D.setOnClickListener {
            navigateToNextActivity()
        }

        button3F.setOnClickListener {
            showToast("This seat is reserved.Please select another seat")
        }

        button4A.setOnClickListener {
            navigateToNextActivity()
        }

        button4B.setOnClickListener {
            navigateToNextActivity()
        }

        button4C.setOnClickListener {
            navigateToNextActivity()
        }

        button4D.setOnClickListener {
            navigateToNextActivity()
        }

        button4E.setOnClickListener {
            navigateToNextActivity()
        }

        button4F.setOnClickListener {
            navigateToNextActivity()
        }

        button5A.setOnClickListener {
            navigateToNextActivity()
        }

        button5B.setOnClickListener {
            navigateToNextActivity()
        }

        button5C.setOnClickListener {
            navigateToNextActivity()
        }

        button5D.setOnClickListener {
            showToast("This seat is reserved.Please select another seat")
        }

        button5E.setOnClickListener {
            showToast("This seat is reserved.Please select another seat")
        }

        button5F.setOnClickListener {
            navigateToNextActivity()
        }

        button6A.setOnClickListener {
            navigateToNextActivity()
        }

        button6C.setOnClickListener {
            navigateToNextActivity()
        }

        button6D.setOnClickListener {
            navigateToNextActivity()
        }

        button6E.setOnClickListener {
            navigateToNextActivity()
        }

        button6F.setOnClickListener {
            navigateToNextActivity()
        }

        confirmButton.setOnClickListener {
            navigateToNextActivity()
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToNextActivity() {
        val intent = Intent(this, BoardingPassActivity::class.java)
        startActivity(intent)
    }
}
