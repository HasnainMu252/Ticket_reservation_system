package com.quiz_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class Your_ticket : AppCompatActivity() {

    private lateinit var gridView: GridView
    private val seatList = mutableListOf<SeatData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_your_ticket)

        initializeSeatNum()

        gridView = findViewById(R.id.gridView)

        val seatAdapter = myAdapter(this, seatList)
        gridView.adapter = seatAdapter
    }

    private fun initializeSeatNum() {
        seatList.clear()  // Ensure the list is empty before adding new items

        for (i in 1..50) {
            val seatNum = "A$i"
            seatList.add(SeatData(num = seatNum))
        }


    }
}