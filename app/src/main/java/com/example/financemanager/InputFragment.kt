package com.example.financemanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class InputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etSalary = view.findViewById<EditText>(R.id.gi_edit_salary)
        val etRent   = view.findViewById<EditText>(R.id.gi_edit_rent)
        val etFood   = view.findViewById<EditText>(R.id.gi_edit_food)
        val btnCalc  = view.findViewById<Button>(R.id.gi_btn_calculate)

        btnCalc.setOnClickListener {
            val salaryStr = etSalary.text.toString()
            val rentStr   = etRent.text.toString()
            val foodStr   = etFood.text.toString()

            if (salaryStr.isEmpty() || rentStr.isEmpty() || foodStr.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val salary = salaryStr.toDouble()
            val rent   = rentStr.toDouble()
            val food   = foodStr.toDouble()

            val bundle = Bundle().apply {
                putDouble("salary", salary)
                putDouble("rent", rent)
                putDouble("food", food)
            }

            val resultFragment = ResultFragment()
            resultFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.gi_fragment_container, resultFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}