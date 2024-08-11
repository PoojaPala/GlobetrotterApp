package com.example.globetrotterapp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class SignInActivity : AppCompatActivity() {

    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var signInButton: Button
    lateinit var signUpText: TextView
    // creating a variable for our
    // Firebase Database.
    lateinit var firebaseDatabase: FirebaseDatabase

    // creating a variable for our Database
    // Reference for Firebase.
    lateinit var databaseReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        emailEditText = findViewById(R.id.editemail)
        passwordEditText = findViewById(R.id.editPass)
        signUpText = findViewById(R.id.signInText)
        signInButton = findViewById(R.id.button)
        // below line is used to get the
        // instance of our FIrebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference().child("UserData")

        (findViewById<TextView>(R.id.forgot_pass)!!).setOnClickListener{
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        signUpText.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        signInButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (validateInputs(email, password)) {

                val userNameRef: DatabaseReference = firebaseDatabase.getReference().child("UserData")
                val queries: Query = userNameRef.orderByChild("email").equalTo(email)
                val eventListener: ValueEventListener = object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.exists()) {
                           if(password == dataSnapshot.child("password").getValue(String::class.java)){
                               // Proceed with sign-in logic
                               Toast.makeText(baseContext, "Sign-In Successful", Toast.LENGTH_SHORT).show()
                               // Navigation to MainActivity with flags to clear previous activities
                               val intent = Intent(baseContext, MainActivity::class.java)
                               intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                               startActivity(intent)
                           }else{
                               passwordEditText.error = "Password is Invalid. Please try again"
                               passwordEditText.requestFocus()
                           }

                        }
                        else{
                            emailEditText.error = "Email Invalid try Sign Up"
                            emailEditText.requestFocus()
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {}
                }
                queries.addListenerForSingleValueEvent(eventListener)

            }
        }
    }

    private fun validateInputs(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            emailEditText.error = "Email is required"
            emailEditText.requestFocus()
            return false
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.error = "Enter a valid email"
            emailEditText.requestFocus()
            return false
        }

        if (password.isEmpty()) {
            passwordEditText.error = "Password is required"
            passwordEditText.requestFocus()
            return false
        }

        if (password.length < 6) {
            passwordEditText.error = "Password must be at least 6 characters"
            passwordEditText.requestFocus()
            return false
        }

        return true
    }
}


