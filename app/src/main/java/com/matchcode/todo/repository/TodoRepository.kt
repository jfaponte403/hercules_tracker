package com.matchcode.todo.repository

import com.matchcode.todo.model.TodoItem

// TodoRepository.kt
class TodoRepository {
    private val todoList = mutableListOf<TodoItem>()
    private var nextId = 0

    // Get all TODO items
    fun getAllTodos(): List<TodoItem> {
        return todoList
    }

    // Add a TODO item
    fun addTodo(title: String) {
        val newTodo = TodoItem(id = nextId++, title = title)
        todoList.add(newTodo)
    }

    // Update a TODO item
    fun updateTodo(updatedTodo: TodoItem) {
        val index = todoList.indexOfFirst { it.id == updatedTodo.id }
        if (index != -1) {
            todoList[index] = updatedTodo
        }
    }

    // Delete a TODO item
    fun deleteTodo(todo: TodoItem) {
        todoList.remove(todo)
    }
}
