package com.technipixl.eval4_and_loichubermont.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expense (
    @PrimaryKey(autoGenerate = true)
    var idExpense:Long = 0,
    var name :String  ,
    var value:Float,
    var expenseOwnerTypeId:Long

)