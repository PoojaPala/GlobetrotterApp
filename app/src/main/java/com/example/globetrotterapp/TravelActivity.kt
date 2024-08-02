package com.example.globetrotterapp

import java.text.SimpleDateFormat
import java.util.Locale
import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TravelActivity : AppCompatActivity() {

    private lateinit var fromSpinner: Spinner
    private lateinit var toSpinner: Spinner
    private lateinit var editFirstName: EditText
    private lateinit var editLastName: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var editTextDate: EditText
    private lateinit var bookButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel)

        // Initialize views
        fromSpinner = findViewById(R.id.FromSpinner)
        toSpinner = findViewById(R.id.ToSpinner)
        editFirstName = findViewById(R.id.editfname)
        editLastName = findViewById(R.id.editlname)
        radioGroup = findViewById(R.id.radioGroup)
        editTextDate = findViewById(R.id.editTextDate)
        bookButton = findViewById(R.id.book)

        // Set up spinners
        val fromAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.from_locations,
            android.R.layout.simple_spinner_item
        )
        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        fromSpinner.adapter = fromAdapter

        val toAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.to_locations,
            android.R.layout.simple_spinner_item
        )
        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        toSpinner.adapter = toAdapter

        // Set up button click listener
        bookButton.setOnClickListener {
            // Extract data from input fields
            val firstName = editFirstName.text.toString()
            val lastName = editLastName.text.toString()
            val gender = if (radioGroup.checkedRadioButtonId == R.id.female) "Female" else "Male"
            val fromLocation = fromSpinner.selectedItem.toString()
            val toLocation = toSpinner.selectedItem.toString()
            val travelDate = editTextDate.text.toString()

            // Validate input if necessary

            // Proceed to FlightBookActivity
            val intent = Intent(this, FlightBookActivity::class.java).apply {
                putExtra("FIRST_NAME", firstName)
                putExtra("LAST_NAME", lastName)
                putExtra("GENDER", gender)
                putExtra("FROM_LOCATION", fromLocation)
                putExtra("TO_LOCATION", toLocation)
                putExtra("TRAVEL_DATE", travelDate)
            }
            startActivity(intent)
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = Calendar.getInstance().apply {
                    set(selectedYear, selectedMonth, selectedDay)
                }.time
                val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                editTextDate.setText(dateFormat.format(selectedDate))
            },
            day, month, year
        )

        datePickerDialog.show()
    }
}
