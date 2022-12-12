package com.example.recyclerviewtodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewtodo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var todoList = mutableListOf(
            Todo("Email ACTION team", true),
            Todo("File leave application on ODTR", true),
            Todo("Approved 12/07/22 PM", false),
            Todo("Approved 12/09/22 AM", false),
            Todo("Approved 12/19/22", false),
            Todo("Approved 12/20/22", false)
        )

        val adapterTodo = TodoAdapter(todoList)
        binding.rvTodos.adapter = adapterTodo
        binding.rvTodos.layoutManager = LinearLayoutManager(this)

        binding.btnAddToDo.setOnClickListener{
            val title = binding.etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapterTodo.notifyItemInserted(todoList.size - 1)
            Toast.makeText(this, "Been Here, TDLS: ${todoList.size}", Toast.LENGTH_SHORT)
        }

    }
}