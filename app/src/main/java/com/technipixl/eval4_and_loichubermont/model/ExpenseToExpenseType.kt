package com.technipixl.eval4_and_loichubermont.model

import androidx.room.Embedded
import androidx.room.Relation

data class ExpenseToExpenseType (
    @Embedded val expenseType :Expense,
            @Relation(parentColumn = "expenseOwnerTypeId", entityColumn = "idExpenseType")

            val expense:ExpenseType
)