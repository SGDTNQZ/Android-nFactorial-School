package com.projects.nfactorial_school.presentation.registration

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.projects.nfactorial_school.R

class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnRegister : Button = view.findViewById(R.id.btn_register)
        btnRegister.setOnClickListener{
            Log.d("Register button", "Register button was pressed")

        }
    }
}