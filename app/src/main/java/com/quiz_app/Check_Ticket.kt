package com.quiz_app

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Check_Ticket : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_check_ticket)

        val bookingsListView: ListView = findViewById(R.id.bookingsListView)

        // Get bookings from intent
        val bookings = intent.getSerializableExtra("bookings") as? List<BookingData> ?: emptyList()

        // Create a display list
        val displayList = bookings.map { "Name: ${it.username}\nSeats: ${it.seats}" }

        // Set up the ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, displayList)
        bookingsListView.adapter = adapter
    }

    }
