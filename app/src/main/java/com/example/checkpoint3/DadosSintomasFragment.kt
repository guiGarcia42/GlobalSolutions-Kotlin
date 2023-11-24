package com.example.checkpoint3

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.checkpoint3.databinding.FragmentDadosSaudeBinding
import com.example.checkpoint3.databinding.FragmentDadosSintomasBinding

class DadosSintomasFragment : Fragment() {


    private var _binding: FragmentDadosSintomasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDadosSintomasBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val nextButton = binding.nextButton
        nextButton.setOnClickListener {
            findNavController().navigate(R.id.nav_fila)
        }

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}