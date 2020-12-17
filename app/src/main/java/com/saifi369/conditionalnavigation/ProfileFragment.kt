package com.saifi369.conditionalnavigation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val currentBackStackEntry = findNavController().currentBackStackEntry
        val savedStateHandle = currentBackStackEntry!!.savedStateHandle

        savedStateHandle.getLiveData<Boolean>(LoginFragment.LOGIN_SUCCESSFUL)
            .observe(currentBackStackEntry){
                if(!it){
                    Toast.makeText(requireContext(), "Please login to see your profile", Toast.LENGTH_SHORT).show()

                    val startDest = findNavController().graph.startDestination
                    val navOption = NavOptions.Builder()
                        .setPopUpTo(startDest,true)
                        .build()
                    findNavController().navigate(startDest,null,navOption)
                }
            }


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (UserLoginInfo.user == null) {
            Toast.makeText(requireContext(), "Please login first", Toast.LENGTH_SHORT).show()

            val navOptions = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build()

            findNavController().navigate(R.id.loginFragment, null, navOptions)
        } else {

            val username = UserLoginInfo.user!!.username
            Toast.makeText(requireContext(), "Hi, $username", Toast.LENGTH_SHORT).show()

            val text = getString(R.string.welcome, username)
            tv_welcome.text = text
        }
    }
}