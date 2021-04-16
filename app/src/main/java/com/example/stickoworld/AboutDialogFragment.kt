package com.example.stickoworld

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import java.util.*

class AboutDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialog: AlertDialog = AlertDialog.Builder(
            Objects.requireNonNull(activity)!!
        )
            .setView(R.layout.about_layout)
            .create()
        alertDialog.show()
        val btn = alertDialog.findViewById<AppCompatButton>(R.id.btnRound)!!
        btn.setOnClickListener { v: View? -> alertDialog.dismiss() }
        return alertDialog
    }
}
