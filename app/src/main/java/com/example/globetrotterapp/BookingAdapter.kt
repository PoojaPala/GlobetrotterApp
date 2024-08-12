package com.example.globetrotterapp

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener


class BookingAdapter(
    private val flightsBookingsList: MutableList<FlightsBooking?>,
    val bookingDetailsList: BookingDetailsList,
) :
    RecyclerView.Adapter<BookingAdapter.ViewHolder>() {

    var context: Context? = null
    lateinit var intent : Intent
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.booked_list_vew, parent, false)
        return ViewHolder(view)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.getContext()
        intent = Intent(context, MainActivity::class.java)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val booking = flightsBookingsList[position]
        holder.name.text = booking?.firstName
        holder.arrivalAirport1.text = booking?.fromLocation
        holder.departureAirport1.text = booking?.toLocation
        holder.seatNumber.text = booking?.seatNumber
        holder.DeleteBtn.setOnClickListener{
            val ref = FirebaseDatabase.getInstance().reference.child("FlightsBooking")
            val applesQuery: Query = ref.orderByChild("firstName").equalTo(booking?.firstName)
            applesQuery.addListenerForSingleValueEvent(object : ValueEventListener {
                @SuppressLint("NotifyDataSetChanged")
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (appleSnapshot in dataSnapshot.children) {
                        appleSnapshot.ref.removeValue()
                    }

                    var intent = Intent(bookingDetailsList, BookingDetailsList::class.java)
                    intent.putExtra("email",bookingDetailsList.intent.getStringExtra("email"))
                    intent.putExtra("name", bookingDetailsList.intent.getStringExtra("name"))
                    bookingDetailsList.startActivity(intent)
                    bookingDetailsList.finish()

                }

                override fun onCancelled(databaseError: DatabaseError) {
                    Log.e(TAG, "onCancelled", databaseError.toException())
                }
            })
        }
    }


    override fun getItemCount(): Int {
        return flightsBookingsList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val departureAirport1: TextView = itemView.findViewById(R.id.departureAirport1)
        val arrivalAirport1: TextView = itemView.findViewById(R.id.arrivalAirport1)
        val name: TextView = itemView.findViewById(R.id.name)
        val seatNumber: TextView = itemView.findViewById(R.id.seatNumber)
        val DeleteBtn: Button = itemView.findViewById(R.id.DeleteBtn)

        // define other UI elements here
    }
}
