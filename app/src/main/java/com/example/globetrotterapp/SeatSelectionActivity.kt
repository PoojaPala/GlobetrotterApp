package com.example.globetrotterapp


import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SeatSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        // Initialize buttons
        val button4E: Button = findViewById(R.id.foure)
        val button5C: Button = findViewById(R.id.fivec)
        val button6C: Button = findViewById(R.id.sixc)
        val button6B: Button = findViewById(R.id.sixb)
        val button4A: Button = findViewById(R.id.foura)
        val button5A: Button = findViewById(R.id.fivea)
        val button6A: Button = findViewById(R.id.sixa)
        val button4B: Button = findViewById(R.id.fourb)
        val button5B: Button = findViewById(R.id.fiveb)
        val button4C: Button = findViewById(R.id.fourc)
        val button4F: Button = findViewById(R.id.fourf)
        val button4D: Button = findViewById(R.id.fourd)
        val button5D: Button = findViewById(R.id.fived)
        val button6D: Button = findViewById(R.id.sixd)
        val button6E: Button = findViewById(R.id.sixe)
        val button6F: Button = findViewById(R.id.sixf)
        val button5E: Button = findViewById(R.id.fivee)
        val button5F: Button = findViewById(R.id.fivef)
        val button1A: Button = findViewById(R.id.onea)
        val button1K: Button = findViewById(R.id.onek)
        val button2A: Button = findViewById(R.id.twoa)
        val button3A: Button = findViewById(R.id.threeq)
        val button2C: Button = findViewById(R.id.twoc)
        val button3C: Button = findViewById(R.id.threec)
        val button3F: Button = findViewById(R.id.threef)
        val button2F: Button = findViewById(R.id.twof)
        val button2D: Button = findViewById(R.id.twod)
        val button3D: Button = findViewById(R.id.threed)

        val buttonConfirm: Button = findViewById(R.id.book)

        // Set click listeners for buttons
        button4E.setOnClickListener { /* Handle button click */ }
        button5C.setOnClickListener { /* Handle button click */ }
        button6C.setOnClickListener { /* Handle button click */ }
        button6B.setOnClickListener { /* Handle button click */ }
        button4A.setOnClickListener { /* Handle button click */ }
        button5A.setOnClickListener { /* Handle button click */ }
        button6A.setOnClickListener { /* Handle button click */ }
        button4B.setOnClickListener { /* Handle button click */ }
        button5B.setOnClickListener { /* Handle button click */ }
        button4C.setOnClickListener { /* Handle button click */ }
        button4F.setOnClickListener { /* Handle button click */ }
        button4D.setOnClickListener { /* Handle button click */ }
        button5D.setOnClickListener { /* Handle button click */ }
        button6D.setOnClickListener { /* Handle button click */ }
        button6E.setOnClickListener { /* Handle button click */ }
        button6F.setOnClickListener { /* Handle button click */ }
        button5E.setOnClickListener { /* Handle button click */ }
        button5F.setOnClickListener { /* Handle button click */ }
        button1A.setOnClickListener { /* Handle button click */ }
        button1K.setOnClickListener { /* Handle button click */ }
        button2A.setOnClickListener { /* Handle button click */ }
        button3A.setOnClickListener { /* Handle button click */ }
        button2C.setOnClickListener { /* Handle button click */ }
        button3C.setOnClickListener { /* Handle button click */ }
        button3F.setOnClickListener { /* Handle button click */ }
        button2F.setOnClickListener { /* Handle button click */ }
        button2D.setOnClickListener { /* Handle button click */ }
        button3D.setOnClickListener { /* Handle button click */ }

        buttonConfirm.setOnClickListener {
            // Handle confirm button click
            // For example: navigate to another activity
            // startActivity(Intent(this, ConfirmationActivity::class.java))
        }
    }
}
