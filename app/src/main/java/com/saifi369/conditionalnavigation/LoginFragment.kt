package com.saifi369.conditionalnavigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login) {

    companion object{
        const val LOGIN_SUCCESSFUL = "LOGIN_SUCCESSFUL"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val savedStateHandle = findNavController().previousBackStackEntry!!.savedStateHandle
        savedStateHandle.set(LOGIN_SUCCESSFUL,false)

        UserLoginInfo.user = null

        btn_login.setOnClickListener {
            val username = et_username.text.toString()
            val password = et_password.text.toString()
            //authentication

            UserLoginInfo.user = User(username)
            savedStateHandle.set(LOGIN_SUCCESSFUL,true)

            findNavController().popBackStack()
        }
    }
}