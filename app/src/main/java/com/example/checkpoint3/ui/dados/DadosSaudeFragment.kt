package com.example.checkpoint3.ui.dados

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.checkpoint3.R
import com.example.checkpoint3.databinding.FragmentDadosSaudeBinding

class DadosSaudeFragment : Fragment() {

    private var _binding: FragmentDadosSaudeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDadosSaudeBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val saveButton = binding.saveButton
        saveButton.setOnClickListener {
            findNavController().navigate(R.id.nav_home)
        }

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}