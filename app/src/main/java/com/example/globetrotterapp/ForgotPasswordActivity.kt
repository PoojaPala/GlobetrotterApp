package com.example.globetrotterapp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var repeatPasswordEditText: EditText

    // creating a variable for our
    // Firebase Database.
    lateinit var firebaseDatabase: FirebaseDatabase

    // creating a variable for our Database
    // Reference for Firebase.
    lateinit var databaseReference: DatabaseReference

    private lateinit var signUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgot_password)
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.passwordText)
        repeatPasswordEditText = findViewById(R.id.repeatPassword)

        signUpButton = findViewById(R.id.button)

        // below line is used to get the
        // instance of our FIrebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference().child("UserData")

        signUpButton.setOnClickListener {
            val repeatPassword = repeatPasswordEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (validateInputs(email, password, repeatPassword)) {
                // Proceed with sign-up logic
                // For example, save user data to the database or Firebase, then navigate to the next activity
                addDatatoFirebase(email, password, repeatPassword)
            }
        }
    }

    private fun addDatatoFirebase(email: String, password: String, repeatPassword: String) {
        val userNameRef: DatabaseReference = firebaseDatabase.getReference().child("UserData")
        val queries: Query = userNameRef.orderByChild("email").equalTo(email)
        val eventListener: ValueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (userSnapshot in dataSnapshot.children) {
                        userSnapshot.key?.let { userNameRef.child(it).child("password").setValue(password) }

                        Toast.makeText(baseContext, "Password changed successfully", Toast.LENGTH_SHORT).show()
                        val intent = Intent(baseContext, SignInActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }
                } else {
                    emailEditText.error = "Email Already Exists, Try Sign In..."
                    emailEditText.requestFocus()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        }
        queries.addListenerForSingleValueEvent(eventListener)
    }

    private fun validateInputs(email: String, password: String, repeatPassword: String): Boolean {
        if (email.isEmpty()) {
            emailEditText.error = "Email is required"
            emailEditText.requestFocus()
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.error = "Enter a valid email"
            emailEditText.requestFocus()
            return false
        } else if (password.isEmpty()) {
            passwordEditText.error = "Password is required"
            passwordEditText.requestFocus()
            return false
        } else if (password.length < 6) {
            passwordEditText.error = "Password must be at least 6 characters"
            passwordEditText.requestFocus()
            return false
        } else if (password != repeatPassword) {
            repeatPasswordEditText.error = "Password and Repeat password is not matching"
            repeatPasswordEditText.requestFocus()
            return false
        }

        return true
    }
}