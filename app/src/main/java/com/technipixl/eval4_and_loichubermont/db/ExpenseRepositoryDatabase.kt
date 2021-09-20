package com.technipixl.eval4_and_loichubermont.db

import android.content.Context
import androidx.lifecycle.LiveData
import com.technipixl.eval4_and_loichubermont.model.Expense
import com.technipixl.eval4_and_loichubermont.model.ExpenseToExpenseType

class ExpenseRepositoryDatabase {
    companion object{
        var expenseDatabase: ExpenseDatabase? = null
        var expenseToExpenseType: LiveData<ExpenseToExpenseType>? = null
        fun getAllExpense(context: Context): LiveData<List<Expense>> {
            if(expenseDatabase == null) {
                //expenseDatabase = initializeDB(context)
            }
            return expenseDatabase!!.expenseDao().getAllExpense()
        }

    }

}