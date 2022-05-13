package com.example.moviefun.ui.base

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.example.moviefun.R

class DialogUtils {

    companion object {
        fun createLoadingDialog(context: Context?, cancelable: Boolean): Dialog? {
            val dialog = context?.let { Dialog(it) }
            dialog?.apply {
                setCancelable(cancelable)
                window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                setContentView(R.layout.loading_dialog_layout)
                show()
            }
            return dialog
        }
    }


}
