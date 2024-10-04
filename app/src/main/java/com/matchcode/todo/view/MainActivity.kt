package com.matchcode.todo.view

// MainActivity.kt
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todokotlinapp.R // Make sure to change this import based on your package structure
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var todoRecyclerView: RecyclerView
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var todoInput: TextInputEditText
    private lateinit var addButton: MaterialButton

    private val viewModel: TodoViewModel by viewModels { TodoViewModelFactory(TodoRepository()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoRecyclerView = findViewById(R.id.recyclerView)
        todoInput = findViewById(R.id.todoInput)
        addButton = findViewById(R.id.addButton)

        todoRecyclerView.layoutManager = LinearLayoutManager(this)
        todoAdapter = TodoAdapter { todo -> viewModel.deleteTodo(todo) }
        todoRecyclerView.adapter = todoAdapter

        // Observe the TODO items
        viewModel.todos.observe(this) { todos ->
            todoAdapter.submitList(todos)
        }

        // Add TODO item
        addButton.setOnClickListener {
            val title = todoInput.text.toString().trim()
            if (title.isNotEmpty()) {
                viewModel.addTodo(title)
                todoInput.text?.clear() // Clear input field after adding
            }
        }

        // Optional: Listen for text changes
        todoInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                addButton.isEnabled = s?.isNotBlank() == true
            }
        })
    }
}

