package com.example.globetrotterapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val emailEditText: EditText = findViewById(R.id.email)
        val nameEditText: EditText = findViewById(R.id.name)
        val passwordEditText: EditText = findViewById(R.id.pass)
        val signUpButton: Button = findViewById(R.id.button)

        signUpButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val name = nameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (validateInputs(email, name, password)) {
                navigateToSignIn()
            } else {
                emailEditText.error = "Invalid email or password"
                nameEditText.error = "Please enter your name"
            }
        }
    }

    private fun validateInputs(email: String, name: String, password: String): Boolean {
        return email.isNotBlank() && name.isNotBlank() && password.isNotBlank()
    }

    private fun navigateToSignIn() {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
        finish()
    }
}

