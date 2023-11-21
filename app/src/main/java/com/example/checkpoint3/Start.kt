package com.example.checkpoint3

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class MainActivity : AppCompatActivity(), ItemListAdapter.OnDeleteItemClickListener, ItemListAdapter.OnChangeItemClickListener {
    private val itemList = mutableListOf<Item>()
    private lateinit var adapter: ItemListAdapter

    private lateinit var addButton: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemNameInput: TextView
    private lateinit var itemAmountInput: TextView

    private lateinit var deleteAllButton: Button

    private val gson = Gson()

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start)

        // Inicializando as variáveis
        addButton = findViewById(R.id.add_button)
        recyclerView = findViewById(R.id.recycler_view)
        itemNameInput = findViewById(R.id.item_name_input)
        itemAmountInput = findViewById(R.id.item_amount_input)

        deleteAllButton = findViewById(R.id.delete_all_button)

        sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        val itemListJson = sharedPreferences.getString("itemList", null)

        // Configurando o RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ItemListAdapter(itemList, this, this)
        recyclerView.adapter = adapter

        if (itemListJson != null) {
            val savedItemList = gson.fromJson(itemListJson, Array<Item>::class.java).toList()
            itemList.addAll(savedItemList)
        }

        // Adicionando um item ao clicar em um botão
        addButton.setOnClickListener {
            val name = itemNameInput.text.toString()
            val amount = itemAmountInput.text.toString()
            val item = Item(name, false, amount)
            addItem(item)
        }

        deleteAllButton.setOnClickListener {
            deleteAll(it)
        }
    }

    private fun saveData() {
        val itemListJson = gson.toJson(itemList)
        editor.putString("itemList", itemListJson)
        editor.apply()
    }
    private fun addItem(item: Item) {
        itemList.add(item)
        saveData()
        adapter.notifyItemInserted(itemList.size - 1)
    }

    override fun onDeleteItemClick(position: Int) {
        itemList.removeAt(position)
        saveData()
        adapter.notifyItemRemoved(position)
    }

    override fun onChangeItemClick(position: Int) {
        itemList[position].status = !itemList[position].status
        saveData()
        adapter.notifyItemChanged(position)
    }

    fun deleteAll(view: View) {
        val itemCount = itemList.size
        itemList.clear()
        adapter.notifyItemRangeRemoved(0, itemCount)
        saveData()
    }

}