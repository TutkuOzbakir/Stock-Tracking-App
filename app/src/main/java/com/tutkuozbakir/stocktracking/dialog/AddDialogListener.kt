package com.tutkuozbakir.stocktracking.dialog

import android.content.ClipData.Item

interface AddDialogListener {
    fun onAddButtonClicked(item: com.tutkuozbakir.stocktracking.model.StockItem)
}