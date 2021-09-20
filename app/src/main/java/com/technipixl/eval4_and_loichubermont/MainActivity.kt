package com.technipixl.eval4_and_loichubermont

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.eval4_and_loichubermont.databinding.ActivityMainBinding
import com.technipixl.eval4_and_loichubermont.model.Expense
import com.technipixl.eval4_and_loichubermont.ui.ExpenseAdapter
import com.technipixl.eval4_and_loichubermont.viewmodel.ExpenseListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var expenseListViewModel: ExpenseListViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ExpenseAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        expenseListViewModel = ViewModelProvider(this).get(ExpenseListViewModel::class.java)
        val dividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
        expenseListViewModel.getAllExpense(this).observeForever {
            updateDataWithExpense(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id :Int = item.itemId
        if (id == R.id.addBook){
            startActivity(Intent(this,AddActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
    fun updateDataWithExpense(expense: List<Expense>) {
        adapter = ExpenseAdapter(expense)
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerView.adapter = adapter
    }
}