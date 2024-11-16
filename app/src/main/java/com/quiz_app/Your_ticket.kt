package com.quiz_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.WindowInsetsCompat


class Your_ticket : AppCompatActivity() {

    private lateinit var gridView: GridView
    private val seatList = mutableListOf<SeatData>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_your_ticket)

        initializeSeatNum()

        gridView = findViewById(R.id.gridView)
        val confirmBookingBtn = findViewById(R.id.confirmBookingBtn) as Button


        val seatAdapter = myAdapter(this, seatList)
        gridView.adapter = seatAdapter


        confirmBookingBtn.setOnClickListener {
            val selectedSeats = seatList.filter { it.isSelected }
            if (selectedSeats.isNotEmpty()) {
                val seatNumbers = selectedSeats.joinToString(", ") { it.num }
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
}