package com.technipixl.eval4_and_loichubermont.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.technipixl.eval4_and_loichubermont.dao.ExpenseDao
import com.technipixl.eval4_and_loichubermont.dao.ExpenseTypeDao
import com.technipixl.eval4_and_loichubermont.model.Expense
import com.technipixl.eval4_and_loichubermont.model.ExpenseType

@Database(entities = arrayOf(Expense::class,ExpenseType::class),version = 1)
abstract class ExpenseDatabase : RoomDatabase() {
    abstract fun expenseDao():ExpenseDao
    abstract fun expenseTypeDao():ExpenseTypeDao
    companion object {

        @Volatile
        private var sharedInstance: ExpenseDatabase? = null

        fun getDB(context: Context) : ExpenseDatabase {
            if (sharedInstance != null) return sharedInstance!!
            synchronized(this) {
                sharedInstance = Room
                    .databaseBuilder(context, ExpenseDatabase::class.java, "book.db")
                    .fallbackToDestructiveMigration()
                    .build()
                return sharedInstance!!
            }
        }
    }
}