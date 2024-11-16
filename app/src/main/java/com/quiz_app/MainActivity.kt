package com.quiz_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val BookYourActivity = findViewById<Button>(R.id.bookYourTicket)
        val CheckTicket = findViewById<Button>(R.id.CheckTicket)
        val AvailTicket = findViewById<Button>(R.id.AvailTicket)

        BookYourActivity.setOnClickListener(){
          val intent = Intent(this,Your_ticket::class.java)

                  startActivity(intent)


        }
        CheckTicket.setOnClickListener(){
            val intent = Intent(this,Check_Ticket::class.java)

            startActivity(intent)


        }
        AvailTicket.setOnClickListener(){
            val intent = Intent(this,Available_ticket::class.java)

            startActivity(intent)


        }




    }
}