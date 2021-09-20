package com.technipixl.eval4_and_loichubermont.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.technipixl.eval4_and_loichubermont.model.Expense
import com.technipixl.eval4_and_loichubermont.model.ExpenseToExpenseType

@Dao
interface ExpenseDao {
    @Query("select * from Expense")
    fun getAllExpense(): LiveData<List<Expense>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expense: Expense): Long
    @Query("SELECT * FROM Expense")
    fun getAll(): LiveData<List<ExpenseToExpenseType>>
}