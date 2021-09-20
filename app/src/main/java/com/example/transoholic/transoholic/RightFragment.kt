package com.example.transoholic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.transoholic.databinding.FragmentRightBinding
//Reference to Udacity kotlin fundamentals..
//Fragment code when all the answers are right

class RightFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentRightBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_right, container, false
        )
        binding.btPlayAgain.setOnClickListener { view: View ->
            view.findNavController().navigate(RightFragmentDirections.rightToQuiz())
        }
        return binding.root
    }
}