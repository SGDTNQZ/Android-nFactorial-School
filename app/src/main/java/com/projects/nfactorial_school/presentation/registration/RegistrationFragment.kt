package com.projects.nfactorial_school.presentation.registration

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.projects.nfactorial_school.MainApp
import com.projects.nfactorial_school.R
import com.projects.nfactorial_school.domain.util.ErrorHandler
import com.projects.nfactorial_school.presentation.login.LoginActivity
import com.projects.nfactorial_school.presentation.registration.event.RegistrationEvent
import com.projects.nfactorial_school.presentation.registration.factory.RegistrationViewModelFactory
import com.projects.nfactorial_school.presentation.registration.viewmodel.RegistrationViewModel
import com.projects.nfactorial_school.presentation.topBar.TopBar
import com.projects.nfactorial_school.ui.theme.NFactorialSchoolTheme

class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    private val viewModel: RegistrationViewModel by viewModels{
        RegistrationViewModelFactory(
            (requireActivity().application as MainApp).authRepository,
            ErrorHandler(requireActivity().application)
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnRegister : Button = view.findViewById(R.id.btn_register)
        val etLogin : EditText = view.findViewById(R.id.et_login)
        val etPassword : EditText = view.findViewById(R.id.et_password)
        val tvError: TextView = view.findViewById(R.id.tv_Error)
        val tvLoginLink: TextView =view.findViewById(R.id.tvLoginLink)

        view.findViewById<ComposeView>(R.id.composeTopBar).setContent {
            NFactorialSchoolTheme{
                TopBar()
            }
        }

        etLogin.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.dispatch(RegistrationEvent.OnLoginChange(s.toString()))
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.dispatch(RegistrationEvent.OnPasswordChange(s.toString()))
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        btnRegister.setOnClickListener{
            viewModel.dispatch(RegistrationEvent.OnRegisterClicked)
        }

        tvLoginLink.setOnClickListener{
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.state.collect { state ->
                if (state.errorMessage != null) {
                    tvError.visibility = View.VISIBLE
                    tvError.text = state.errorMessage
                } else {
                    tvError.visibility = View.INVISIBLE
                }
                state.token?.let { token ->
                    Log.d("RegistrationFragment", "Регистрация успешна, токен: $token")
                }
            }
        }

    }
}