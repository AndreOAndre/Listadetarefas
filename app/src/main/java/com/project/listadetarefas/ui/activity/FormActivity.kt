package com.project.listadetarefas.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.project.listadetarefas.R
import com.project.listadetarefas.dao.DataAcessObject
import com.project.listadetarefas.model.ListModel

class FormActivity : AppCompatActivity(R.layout.activity_form) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setButtonSave()
    }

    private fun setButtonSave() {
        val dao = DataAcessObject()
        val buttonSave = findViewById<Button>(R.id.activity_form_button_save)

        buttonSave.setOnClickListener {
            val listForm = createList()
            dao.share(listForm)
            finish()
            Log.i("form lista activity", "setButtonSave: ${dao.take()}")
        }


    }

    private fun createList(): ListModel {
        val pointTitle = findViewById<EditText>(R.id.activity_form_title)
        val titleForm = pointTitle.text.toString()

        val pointDescription = findViewById<EditText>(R.id.activity_form_description)
        val descriptionForm = pointDescription.text.toString()

        val pointData = findViewById<EditText>(R.id.activity_form_data)
        val dataForm = pointData.text.toString()

        return ListModel(
            title = titleForm,
            description = descriptionForm,
            data = dataForm
        )
    }


}