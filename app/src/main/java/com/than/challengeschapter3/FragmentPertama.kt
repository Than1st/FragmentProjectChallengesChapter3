package com.than.challengeschapter3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.than.challengeschapter3.databinding.FragmentPertamaBinding

class FragmentPertama : Fragment() {
    private var _binding: FragmentPertamaBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPertamaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnToTwo.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragmentPertama_to_fragmentKedua)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}