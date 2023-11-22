package com.example.checkpoint3.ui.dados

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.checkpoint3.R
import com.example.checkpoint3.databinding.FragmentDadosCadastraisBinding

class DadosCadastraisFragment : Fragment() {

    private var _binding: FragmentDadosCadastraisBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dadosCadastraisViewModel =
            ViewModelProvider(this).get(DadosCadastraisViewModel::class.java)

        _binding = FragmentDadosCadastraisBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val nextButton : Button = binding.nextButton
        nextButton.setOnClickListener{
            findNavController().navigate(R.id.nav_dados_saude)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}