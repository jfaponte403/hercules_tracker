package com.matchcode.todo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.matchcode.todo.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view to the activity_main layout
        setContentView(R.layout.activity_main)

        // Find the TextView by its ID and set the text to "Hello, World!"
        val textView: TextView = findViewById(R.id.helloTextView)
        textView.text = "Hello, World!"
    }

}
