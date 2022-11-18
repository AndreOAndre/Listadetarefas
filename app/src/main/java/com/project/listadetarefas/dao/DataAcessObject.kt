package com.project.listadetarefas.dao

import com.project.listadetarefas.model.ListModel

class DataAcessObject {

    companion object {
        private val listDao = mutableListOf<ListModel>()
    }

    fun share(list: ListModel) {
        listDao.add(list)
    }

    fun take(): List<ListModel> {
        return listDao.toList()
    }
}