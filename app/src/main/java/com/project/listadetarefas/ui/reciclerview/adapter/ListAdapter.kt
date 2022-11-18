package com.project.listadetarefas.ui.reciclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.listadetarefas.R
import com.project.listadetarefas.model.ListModel

class ListAdapter(
    private var context: Context,
    adapterList: List<ListModel>

) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private val listItems = adapterList.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincle(list: ListModel) {
            val titleAdapter = itemView.findViewById<TextView>(R.id.itens_list_title)
            titleAdapter.text = list.title

            val descriptionAdapter = itemView.findViewById<TextView>(R.id.itens_list_description)
            descriptionAdapter.text = list.description

            val dataAdapter = itemView.findViewById<TextView>(R.id.itens_list_data)
            dataAdapter.text = list.data
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.items_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = listItems[position]
        holder.vincle(list)
    }

    override fun getItemCount(): Int = listItems.size


    fun update(listUpdate: List<ListModel>) {
        this.listItems.clear()
        this.listItems.addAll(listUpdate)
        notifyDataSetChanged()
    }

}



