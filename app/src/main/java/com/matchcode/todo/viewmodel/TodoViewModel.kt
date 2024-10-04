package com.matchcode.todo.viewmodel

// TodoViewModel.kt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matchcode.todo.model.TodoItem
import com.matchcode.todo.repository.TodoRepository

class TodoViewModel(private val repository: TodoRepository) : ViewModel() {
    private val _todos = MutableLiveData<List<TodoItem>>()
    val todos: LiveData<List<TodoItem>> get() = _todos

    init {
        loadTodos()
    }

    private fun loadTodos() {
        _todos.value = repository.getAllTodos()
    }

    fun addTodo(title: String) {
        repository.addTodo(title)
        loadTodos() // Refresh the list
    }

    fun updateTodo(todo: TodoItem) {
        repository.updateTodo(todo)
        loadTodos() // Refresh the list
    }

    fun deleteTodo(todo: TodoItem) {
        repository.deleteTodo(todo)
        loadTodos() // Refresh the list
    }
}
