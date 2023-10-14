package com.example.MidtermApp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.a323midterm.databinding.FragmentMainBinding

class MainFragment: Fragment() {
    val TAG = "MainFragment"
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        /**
         * The onCreateView function is overridden to take the arguments from the noteId and set the view model
         *
         * @param inflater used to inflate the view model
         * @param container used in the binding containing the view grop
         * @param savedInstanceState holding the previous state of the object to reflect the current behaviors
         *
         * @returns the view
         * */
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        val viewModelFactory = GameViewModelFactory()
        val viewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(GameViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.PlayButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainToGame()
            findNavController().navigate(action)
        }

        binding.HighScoreButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainToHs()
            findNavController().navigate(action)
        }

        return view

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}