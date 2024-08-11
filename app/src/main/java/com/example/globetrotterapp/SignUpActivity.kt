package com.example.globetrotterapp


import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener


class SignUpActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var signInText: TextView
    private lateinit var lastNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signUpButton: Button

    // creating a variable for our
    // Firebase Database.
    lateinit var firebaseDatabase: FirebaseDatabase

    // creating a variable for our Database
    // Reference for Firebase.
    lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signInText = findViewById(R.id.signInText)
        nameEditText = findViewById(R.id.name)
        lastNameEditText = findViewById(R.id.lastName)
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.pass)
        signUpButton = findViewById(R.id.button)

        // below line is used to get the
        // instance of our FIrebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference().child("UserData")

        signUpButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val lastNmae = lastNameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (validateInputs(name,lastNmae, email, password)) {
                // Proceed with sign-up logic
                // For example, save user data to the database or Firebase, then navigate to the next activity
                addDatatoFirebase(name,lastNmae, email, password)
            }
        }

        signInText.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    private fun addDatatoFirebase(
        firstName: String,
        lastNmae: String,
        email: String,
        password: String
    ) {
        val user = UserModel(firstName,lastNmae, email, password)

        val userNameRef: DatabaseReference = firebaseDatabase.getReference().child("UserData")
        val queries: Query = userNameRef.orderByChild("email").equalTo(email)
        val eventListener: ValueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (!dataSnapshot.exists()) {
                    databaseReference.addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(@NonNull snapshot: DataSnapshot) {

                            Toast.makeText(baseContext, "Sign-Up Successful", Toast.LENGTH_SHORT).show()
                            // Example navigation to another activity
                            val intent = Intent(baseContext, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            intent.putExtra("email",email)
                            intent.putExtra("name",
                                firstName + " " +
                                        lastNmae
                            )
                            startActivity(intent)
                        }

                        override fun onCancelled(@NonNull error: DatabaseError) {
                            // if the data is not added or it is cancelled then
                            // we are displaying a failure toast message.
                            Toast.makeText(baseContext, "Fail to add data $error", Toast.LENGTH_SHORT)
                                .show()
                        }
                    })

                    databaseReference.push().setValue(user)
                }
                else{
                    emailEditText.error = "Email Already Exists, Try Sign In..."
                    emailEditText.requestFocus()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        }
        queries.addListenerForSingleValueEvent(eventListener)
        // we are use add value event listener method
        // which is called with database reference.


    }

    private fun validateInputs(name: String,lastname: String, email: String, password: String): Boolean {
        if (name.isEmpty()) {
            nameEditText.error = "First Name is required"
            nameEditText.requestFocus()
            return false
        }

       else if (lastname.isEmpty()) {
            nameEditText.error = "Last Name is required"
            nameEditText.requestFocus()
            return false
        }

        else if (email.isEmpty()) {
            emailEditText.error = "Email is required"
            emailEditText.requestFocus()
            return false
        }

        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.error = "Enter a valid email"
            emailEditText.requestFocus()
            return false
        }

        else if (password.isEmpty()) {
            passwordEditText.error = "Password is required"
            passwordEditText.requestFocus()
            return false
        }

        else if (password.length < 6) {
            passwordEditText.error = "Password must be at least 6 characters"
            passwordEditText.requestFocus()
            return false
        }

        return true
    }
}

