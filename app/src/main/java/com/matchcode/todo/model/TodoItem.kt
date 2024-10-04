package com.matchcode.todo.model

data class TodoItem(
    val id: Int,
    var title: String,
    var isCompleted: Boolean = false
)