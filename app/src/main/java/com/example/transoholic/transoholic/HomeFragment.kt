package com.example.transoholic
//Reference to Udacities Android Kotlin fundamentals
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.transoholic.databinding.FragmentHomeBinding

class HomeFragment:Fragment(){
    private lateinit var binding:FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false)
        binding.submitButton.setOnClickListener {v : View ->
            v.findNavController().navigate(
                HomeFragmentDirections.actionHomeToQuiz()
            )
        }
        binding.btWord.setOnClickListener {v : View ->
            v.findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToWordFragment()
            )
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.navigation_drawer_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

}