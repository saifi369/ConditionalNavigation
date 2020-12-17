package com.saifi369.conditionalnavigation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = UserLoginInfo.user!!.username
        Toast.makeText(requireContext(), "Hi, $username", Toast.LENGTH_SHORT).show()

        val text = getString(R.string.welcome, username)
        tv_welcome.text = text
    }
}