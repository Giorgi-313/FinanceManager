package com.example.financemanager

class FinanceManager(private val model: FinanceModel) {


    private val savingsPercent = "Iremadze".length + 2.0

    val totalExpenses: Double
        get() = model.rent + model.food

    val balance: Double
        get() = model.salary - totalExpenses

    val totalSavings: Double
        get() = balance * (savingsPercent / 100.0)

    val isOverBudget: Boolean
        get() = totalExpenses > model.salary

    val savingsPercentDisplay: Double
        get() = savingsPercent
}