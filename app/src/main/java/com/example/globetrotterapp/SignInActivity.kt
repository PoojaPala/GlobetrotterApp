package com.example.globetrotterapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val emailEditText: EditText = findViewById(R.id.editTextTextEmailAddress)
        val passwordEditText: EditText = findViewById(R.id.editTextText)
        val signInButton: Button = findViewById(R.id.button)
        val forgotPasswordTextView: TextView = findViewById(R.id.forgot_pass)

        signInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (validateInputs(email, password)) {
                navigateToHome()
            } else {
                emailEditText.error = "Invalid email or password"
            }
        }

        forgotPasswordTextView.setOnClickListener {
            // Navigate to another activity if needed
        }
    }

    private fun validateInputs(email: String, password: String): Boolean {
        return email.isNotBlank() && password.isNotBlank()
    }

    private fun navigateToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}

