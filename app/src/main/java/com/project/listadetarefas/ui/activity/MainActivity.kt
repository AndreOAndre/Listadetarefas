package com.project.listadetarefas.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.listadetarefas.R
import com.project.listadetarefas.dao.DataAcessObject
import com.project.listadetarefas.ui.reciclerview.adapter.ListAdapter

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val dao = DataAcessObject()
    private val adapter = ListAdapter(context = this, adapterList = dao.take())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(this, "Welcome at your task list", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.take())
        setRecyclerView()
        setFab()
    }

    private fun setRecyclerView() {
        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.activity_main_reciclerView)
        recyclerView.adapter = adapter

    }

    private fun setFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_main_fab)
        fab.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }
    }


}
