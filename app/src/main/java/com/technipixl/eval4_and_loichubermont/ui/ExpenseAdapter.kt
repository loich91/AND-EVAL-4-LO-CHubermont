package com.technipixl.eval4_and_loichubermont.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.eval4_and_loichubermont.databinding.ExpanseCellBinding
import com.technipixl.eval4_and_loichubermont.model.Expense

class ExpenseAdapter(var expenseTab:List<Expense>):RecyclerView.Adapter<ExpenseAdapter.ExpenseRowHolder>() {
    private lateinit var binding:ExpanseCellBinding
    class ExpenseRowHolder(private var binding:ExpanseCellBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(expenseTab: Expense){
            binding.name.text = expenseTab.name
            binding.value.text = expenseTab.value.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseRowHolder {
        binding = ExpanseCellBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ExpenseRowHolder(binding)
    }

    override fun onBindViewHolder(holder: ExpenseRowHolder, position: Int) {
        holder.bind(expenseTab[position])
    }

    override fun getItemCount(): Int {
        return expenseTab.count()
    }
}