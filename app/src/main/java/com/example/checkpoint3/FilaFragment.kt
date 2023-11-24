package com.example.checkpoint3

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.checkpoint3.databinding.FragmentDadosSaudeBinding
import com.example.checkpoint3.databinding.FragmentFilaBinding

class FilaFragment : Fragment() {

    private var _binding: FragmentFilaBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFilaBinding.inflate(inflater, container, false)
        val root = binding.root

        val cancelarButton = binding.cancelarButton
        cancelarButton.setOnClickListener {
            findNavController().popBackStack(findNavController().graph.startDestinationId, false)
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}