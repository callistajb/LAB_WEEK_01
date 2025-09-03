package com.example.lab_week_01

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val nameSubmit = findViewById<Button>(R.id.name_submit)

        nameSubmit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)?.text.toString().trim()
            val nimInput = findViewById<TextInputEditText>(R.id.nim_input)?.text.toString().trim()

            when {
                nameInput.isEmpty() -> {
                    showToast(getString(R.string.name_empty))
                }
                nimInput.length != 11 -> {
                    showToast(getString(R.string.nim_invalid))
                }
                else -> {
                    val message = getString(R.string.display_message, nameInput, nimInput)
                    nameDisplay.text = message
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).apply {
            setGravity(Gravity.CENTER, 0, 0)
            show()
        }
    }
}