package com.tutkuozbakir.stocktracking.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDialog
import com.tutkuozbakir.stocktracking.databinding.AddItemDialogBinding
import android.view.Window
import android.widget.Toast
import com.tutkuozbakir.stocktracking.model.StockItem

class AddItemDialog(context: Context, var addDialogListener: AddDialogListener): AppCompatDialog(context) {

    private lateinit var binding: AddItemDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddItemDialogBinding.inflate(LayoutInflater.from(context))
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)

        binding.tvDialogAdd.setOnClickListener {
            val name = binding.etDialogItemName.text.toString()
            val amount = binding.etDialogItemAmount.text.toString().toInt()
            if(name.isNullOrEmpty()) {
                Toast.makeText(context, "Please enter a name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = StockItem(name, amount)
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        binding.tvDialogCancel.setOnClickListener {
            cancel()
        }
    }
}