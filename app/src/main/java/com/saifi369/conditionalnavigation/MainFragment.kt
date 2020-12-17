package com.saifi369.conditionalnavigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_show_profile.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToProfileFragment()
            findNavController().navigate(action)
        }
    }
}