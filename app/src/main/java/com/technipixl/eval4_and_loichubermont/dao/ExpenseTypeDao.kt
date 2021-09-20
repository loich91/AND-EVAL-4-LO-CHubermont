package com.technipixl.eval4_and_loichubermont.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.technipixl.eval4_and_loichubermont.model.ExpenseToExpenseType
import com.technipixl.eval4_and_loichubermont.model.ExpenseType

@Dao
interface ExpenseTypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expenseType: ExpenseType): Long
    @Query("select * from expenseType")
    suspend fun getAllType():List<ExpenseType>

}