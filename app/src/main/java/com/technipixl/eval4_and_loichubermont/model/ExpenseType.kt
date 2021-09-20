package com.technipixl.eval4_and_loichubermont.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ExpenseType (
    @PrimaryKey(autoGenerate = true)
    var idExpenseType :Long = 0,
    var name:String
)