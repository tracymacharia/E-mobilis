package com.macharia.osotuahomes

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity : AppCompatActivity() {
    private var cardNumberEditText: EditText? = null
    private var cvvEditText: EditText? = null
    private var payButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_form)
        cardNumberEditText = findViewById(R.id.cardNumberEditText)
        val expirationEditText = findViewById<EditText>(R.id.expirationEditText)
        cvvEditText = findViewById(R.id.cvvEditText)
        payButton = findViewById(R.id.payButton)
        payButton.setOnClickListener(View.OnClickListener { v: View? ->
            // Perform payment processing here (simulate payment).
            // In a real app, you'd integrate with a payment gateway.
            // For this example, we'll just display a success message.
            displayPaymentSuccess()
        })
    }

    private fun displayPaymentSuccess() {
        Toast.makeText(this, "Payment successful!", Toast.LENGTH_SHORT).show()
    }

    fun setCardNumberEditText(cardNumberEditText: EditText?) {
        this.cardNumberEditText = cardNumberEditText
    }

    fun setCvvEditText(cvvEditText: EditText?) {
        this.cvvEditText = cvvEditText
    }
}