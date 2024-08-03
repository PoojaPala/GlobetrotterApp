package com.example.globetrotterapp


import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.util.*

class TravelActivity : AppCompatActivity() {

    private lateinit var firstName: TextInputEditText
    private lateinit var lastName: TextInputEditText
    private lateinit var genderGroup: RadioGroup
    private lateinit var fromSpinner: Spinner
    private lateinit var toSpinner: Spinner
    private lateinit var dateOfTravel: EditText
    private lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel)

        firstName = findViewById(R.id.editfname)
        lastName = findViewById(R.id.editlname)
        genderGroup = findViewById(R.id.radioGroup)
        //fromSpinner = findViewById(R.id.FromSpinner)
        //toSpinner = findViewById(R.id.ToSpinner)
        dateOfTravel = findViewById(R.id.editTextDate)
        continueButton = findViewById(R.id.book)

        dateOfTravel.setOnClickListener {
            showDatePickerDialog()
        }

        continueButton.setOnClickListener {
            val intent = Intent(this, FlightBookActivity::class.java).apply {
                putExtra("firstName", firstName.text.toString())
                putExtra("lastName", lastName.text.toString())
                putExtra("gender", getSelectedGender())
                putExtra("from", fromSpinner.selectedItem.toString())
                putExtra("to", toSpinner.selectedItem.toString())
                putExtra("dateOfTravel", dateOfTravel.text.toString())
            }
            startActivity(intent)
        }
    }


    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            dateOfTravel.setText(selectedDate)
        }, year, month, day)

        datePickerDialog.show()
    }

    private fun getSelectedGender(): String {
        return when (genderGroup.checkedRadioButtonId) {
            R.id.female -> "Female"
            R.id.male -> "Male"
            else -> ""
        }
    }
}
