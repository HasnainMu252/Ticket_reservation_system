package com.quiz_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class myAdapter(val context: Context , private val seats: List<SeatData>) : BaseAdapter() {
    override fun getCount(): Int {
        return seats.size
    }

    override fun getItem(position: Int): Any {
        return seats[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.each_grid, parent, false)
        val seatButton = view.findViewById<AppCompatButton>(R.id.eachGrid)

        val seat = seats[position]
//set the num of seat
        seatButton.text = seat.num

        val background =  if (seat.isSelected){
            ContextCompat.getColor(context,R.color.blue)

        }else{
            ContextCompat.getColor(context,R.color.green)

        }
        seatButton.setBackgroundColor(background)

        seatButton.setOnClickListener(){
            seat.isSelected = !seat.isSelected
            notifyDataSetChanged()
        }


        return view
    }


}