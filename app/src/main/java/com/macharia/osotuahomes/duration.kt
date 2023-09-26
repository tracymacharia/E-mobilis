package com.macharia.osotuahomes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

internal class MainActivity : AppCompatActivity() {
    private var checkInDateEditText: EditText? = null
    private var checkOutDateEditText: EditText? = null
    private var numberOfNightsTextView: TextView? = null
    private var totalCostTextView: TextView? = null
    private var checkInCalendar: Calendar? = null
    private var checkOutCalendar: Calendar? = null
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
    private val nightlyRate = 100.0 // Replace with your nightly rate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_duration)
        checkInDateEditText = findViewById(R.id.checkInDate)
        checkOutDateEditText = findViewById(R.id.checkOutDate)
        numberOfNightsTextView = findViewById(R.id.numberOfNights)
        totalCostTextView = findViewById(R.id.totalCost)
        checkInCalendar = Calendar.getInstance()
        checkOutCalendar = Calendar.getInstance()
        checkInDateEditText.setOnClickListener(View.OnClickListener { showDatePickerDialog(checkInCalendar, checkInDateEditText) })
        checkOutDateEditText.setOnClickListener(View.OnClickListener { v: View? -> showDatePickerDialog(checkOutCalendar, checkOutDateEditText) })
    }

    private fun showDatePickerDialog(calendar: Calendar?, editText: EditText?) {
        val datePickerDialog = DatePickerDialog(
                this,
                { view, year, month, dayOfMonth ->
                    calendar!![year, month] = dayOfMonth
                    val formattedDate = dateFormat.format(calendar.time)
                    editText!!.setText(formattedDate)
                    if (editText === checkInDateEditText) {
                        calculateNightsAndCost()
                    }
                },
                calendar!![Calendar.YEAR],
                calendar[Calendar.MONTH],
                calendar[Calendar.DAY_OF_MONTH]
        )
        datePickerDialog.show()
    }

    private fun calculateNightsAndCost() {
        val diffInMillis = checkOutCalendar!!.timeInMillis - checkInCalendar!!.timeInMillis
        val nights = (diffInMillis / (1000 * 60 * 60 * 24)).toInt() // Calculate nights from milliseconds
        val totalCost = nights * nightlyRate
        numberOfNightsTextView!!.text = "Nights: $nights"
        totalCostTextView!!.text = "Total Cost: $$totalCost"
    }
}