package com.technipixl.eval4_and_loichubermont.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.technipixl.eval4_and_loichubermont.db.ExpenseRepositoryDatabase
import com.technipixl.eval4_and_loichubermont.model.Expense

class ExpenseListViewModel:ViewModel() {
    var liveDataExpenseList: LiveData<List<Expense>>? = null

    fun getAllExpense(context: Context): LiveData<List<Expense>> {
        return ExpenseRepositoryDatabase.getAllExpense(context)
    }
}