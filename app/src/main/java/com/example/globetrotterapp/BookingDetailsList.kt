package com.example.globetrotterapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import org.w3c.dom.Text


class BookingDetailsList : AppCompatActivity() {

    private lateinit var tasksRecyclerView: RecyclerView
    private lateinit var noDataFound: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_details_list)

        tasksRecyclerView = findViewById(R.id.tasksRecyclerView)
        noDataFound = findViewById(R.id.NoDataFound)

        getData()
    }

    fun getData() {
        val userNameRef: DatabaseReference = FirebaseDatabase.getInstance().getReference().child("FlightsBooking")
        val flightsBookingsList: MutableList<FlightsBooking?> = ArrayList<FlightsBooking?>()
        val queries: Query = userNameRef.orderByChild("email").equalTo(intent.getStringExtra("email"))
        val eventListener: ValueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    flightsBookingsList.clear()
                    for (userSnapshot in dataSnapshot.children) {
                        val booking  = FlightsBooking(
                            userSnapshot.child("firstName").value.toString(),
                            userSnapshot.child("email").value.toString(),
                            userSnapshot.child("fromLocation").value.toString(),
                            userSnapshot.child("toLocation").value.toString(),
                            userSnapshot.child("seatNumber").value.toString()
                        )
                        flightsBookingsList.add(booking)

                    }

                    if(flightsBookingsList.size>0){
                        tasksRecyclerView.visibility = View.VISIBLE
                        noDataFound.visibility = View.GONE
                        val adapter = BookingAdapter(flightsBookingsList,this@BookingDetailsList)
                        tasksRecyclerView.adapter = adapter
                        tasksRecyclerView.layoutManager = LinearLayoutManager(this@BookingDetailsList)
                    }
                    else{
                        tasksRecyclerView.visibility = View.GONE
                        noDataFound.visibility = View.VISIBLE
                    }


                }
                else
                {
                    tasksRecyclerView.visibility = View.GONE
                    noDataFound.visibility = View.VISIBLE
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        }
        queries.addListenerForSingleValueEvent(eventListener)
    }
}