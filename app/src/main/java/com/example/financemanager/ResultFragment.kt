package com.example.financemanager

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvName = view.findViewById<TextView>(R.id.gi_tv_name)
        val tvYear = view.findViewById<TextView>(R.id.gi_tv_year)
        tvYear.text = "Year of Birth: 2005"
        tvName.text = "Giorgi Iremadze"

        val salary = arguments?.getDouble("salary") ?: 0.0
        val rent   = arguments?.getDouble("rent")   ?: 0.0
        val food   = arguments?.getDouble("food")   ?: 0.0

        val model   = FinanceModel(salary, rent, food)
        val manager = FinanceManager(model)

        val tvSalary   = view.findViewById<TextView>(R.id.gi_tv_salary)
        val tvRent     = view.findViewById<TextView>(R.id.gi_tv_rent)
        val tvFood     = view.findViewById<TextView>(R.id.gi_tv_food)
        val tvExpenses = view.findViewById<TextView>(R.id.gi_tv_expenses)
        val tvBalance  = view.findViewById<TextView>(R.id.gi_tv_balance)
        val tvSavings  = view.findViewById<TextView>(R.id.gi_tv_savings)
        val tvPercent  = view.findViewById<TextView>(R.id.gi_tv_savings_percent)
        val tvResult   = view.findViewById<TextView>(R.id.gi_tv_result_status)
        val cardStatus = view.findViewById<androidx.cardview.widget.CardView>(R.id.gi_card_status)

        tvSalary.text   = "Salary: $%.2f".format(salary)
        tvRent.text     = "Rent: $%.2f".format(rent)
        tvFood.text     = "Food: $%.2f".format(food)
        tvExpenses.text = "Total Expenses: $%.2f".format(manager.totalExpenses)
        tvBalance.text  = "Balance: $%.2f".format(manager.balance)
        tvSavings.text  = "Total Savings: $%.2f".format(manager.totalSavings)
        tvPercent.text  = "Savings Rate: ${manager.savingsPercentDisplay.toInt()}%"

        if (manager.isOverBudget) {
            tvResult.text = "Over Budget!"
            tvResult.setTextColor(Color.WHITE)
            cardStatus.setCardBackgroundColor(Color.RED)
            tvExpenses.setTextColor(Color.RED)
            tvBalance.setTextColor(Color.RED)
            tvSavings.setTextColor(Color.RED)
        } else {
            tvResult.text = "Within Budget"
            tvResult.setTextColor(Color.WHITE)
            cardStatus.setCardBackgroundColor(Color.parseColor("#2E7D32"))
            tvExpenses.setTextColor(Color.parseColor("#2E7D32"))
            tvBalance.setTextColor(Color.parseColor("#2E7D32"))
            tvSavings.setTextColor(Color.parseColor("#2E7D32"))
        }
    }
}