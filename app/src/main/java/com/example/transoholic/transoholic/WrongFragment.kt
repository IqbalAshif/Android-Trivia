package com.example.transoholic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.transoholic.databinding.FragmentWrongBinding
//when answer are wrong
//reference to android kotlin fundamentals

class WrongFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentWrongBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_wrong, container, false)
        binding.btTryAgain.setOnClickListener { view: View ->
            view.findNavController().navigate(WrongFragmentDirections.wrongToQuiz())
        }
        return binding.root
    }
}