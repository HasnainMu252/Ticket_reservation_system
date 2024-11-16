package com.quiz_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import java.io.Serializable
import android.widget.GridView

import androidx.appcompat.app.AppCompatActivity

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog



class Your_ticket : AppCompatActivity() {

    private lateinit var gridView: GridView
    private val seatList = mutableListOf<SeatData>()
    private val bookings = mutableListOf<BookingData>() // To store confirmed bookings


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_your_ticket)

        initializeSeatNum()

        gridView = findViewById(R.id.gridView)
        val confirmBookingBtn = findViewById(R.id.confirmBookingBtn) as Button
        val checkTicketsBtn: Button = findViewById(R.id.checkTicketsBtn)


        val seatAdapter = myAdapter(this, seatList)
        gridView.adapter = seatAdapter

        checkTicketsBtn.setOnClickListener {
            val intent = Intent(this, Check_Ticket::class.java)
            intent.putExtra("bookings", ArrayList(bookings)) // Pass bookings to the next activity
            startActivity(intent)
        }
        confirmBookingBtn.setOnClickListener {
            val selectedSeats = seatList.filter { it.isSelected }
            if (selectedSeats.isNotEmpty()) {
                val seatNumbers = selectedSeats.joinToString(", ") { it.num }
                showNameInputDialog(seatNumbers)
                Toast.makeText(this, "Seats Confirmed: $seatNumbers", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please select at least one seat", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initializeSeatNum() {
        seatList.clear()  // Ensure the list is empty before adding new items

        for (i in 1..50) {
            val seatNum = "A$i"
            seatList.add(SeatData(num = seatNum))
        }


    }

    private fun showNameInputDialog(seatNumbers: String) {
        val dialogView = layoutInflater.inflate(R.layout.diaglog_name, null)
        val nameEditText: EditText = dialogView.findViewById(R.id.editname)

        AlertDialog.Builder(this)
            .setTitle("Enter Your Name")
            .setView(dialogView)
            .setPositiveButton("Confirm Booking") { _, _ ->
                val userName = nameEditText.text.toString()
                if (userName.isNotEmpty()) {
                    saveBooking(userName, seatNumbers)
                    Toast.makeText(this, "Booking Confirmed", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun saveBooking(name: String, seats: String) {
        bookings.add(BookingData(name, seats))
        // Reset seat selection
        seatList.forEach { it.isSelected = false }
        (gridView.adapter as myAdapter).notifyDataSetChanged()
    }
}