package com.technipixl.eval4_and_loichubermont.db

import android.content.Context
import androidx.lifecycle.LiveData
import com.technipixl.eval4_and_loichubermont.model.Expense
import com.technipixl.eval4_and_loichubermont.model.ExpenseToExpenseType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExpenseRepositoryDatabase {
    companion object{
        var expenseDatabase: ExpenseDatabase? = null
        var expenseToExpenseType: LiveData<ExpenseToExpenseType>? = null
        fun getAllExpense(context: Context): LiveData<List<Expense>> {
            if(expenseDatabase == null) {
                expenseDatabase = initializeDB(context)
            }
            return expenseDatabase!!.expenseDao().getAllExpense()
        }

        private fun initializeDB(context: Context): ExpenseDatabase {
            val db = ExpenseDatabase.getDB(context)
            CoroutineScope(Dispatchers.IO).launch {
                val expense = ExpenseDatabase!!.getDB(context).expenseDao()

                    expenseDatabase!!.expenseDao().insert(Expense(idExpense = 1,"Tva",5.8f,1))
                    expenseDatabase!!.expenseDao().insert(Expense(idExpense = 2,"Taxe tv",25.4f,1))
                    expenseDatabase!!.expenseDao().insert(Expense(idExpense = 3,"hello taxe",55.8f,1))

            }
            return db
        }

    }

}