package com.example.globetrotterapp


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class TravelActivity : AppCompatActivity() {

    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var fromSpinner: Spinner
    private lateinit var toSpinner: Spinner
    private lateinit var dateEditText: EditText
    private lateinit var transportRadioGroup: RadioGroup
    private lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel)

        firstNameEditText = findViewById(R.id.editfname)
        lastNameEditText = findViewById(R.id.editlname)
        genderRadioGroup = findViewById(R.id.radioGroup)
        fromSpinner = findViewById(R.id.FromSpinner)
        toSpinner = findViewById(R.id.ToSpinner)
        dateEditText = findViewById(R.id.editTextDate)
        transportRadioGroup = findViewById(R.id.radioGroup1)
        continueButton = findViewById(R.id.book)

        continueButton.setOnClickListener {
            handleContinueButtonClick()
        }
    }

    private fun handleContinueButtonClick() {
        val firstName = firstNameEditText.text.toString()
        val lastName = lastNameEditText.text.toString()
        val selectedGenderId = genderRadioGroup.checkedRadioButtonId
        val selectedGender = findViewById<RadioButton>(selectedGenderId)?.text.toString()
        val origin = fromSpinner.selectedItem.toString()
        val destination = toSpinner.selectedItem.toString()
        val travelDate = dateEditText.text.toString()
        val selectedTransportId = transportRadioGroup.checkedRadioButtonId
        val selectedTransport = findViewById<RadioButton>(selectedTransportId)?.text.toString()

        val message = """
            First Name: $firstName
            Last Name: $lastName
            Gender: $selectedGender
            From: $origin
            To: $destination
            Date of Travel: $travelDate
            Mode of Transport: $selectedTransport
        """.trimIndent()

        // Here, you might want to navigate to the next step in the booking process
        // For example:
        // val intent = Intent(this, ConfirmationActivity::class.java)
        // startActivity(intent)
    }
}

