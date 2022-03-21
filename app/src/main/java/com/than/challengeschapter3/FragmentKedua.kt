package com.than.challengeschapter3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.than.challengeschapter3.databinding.FragmentKeduaBinding

class FragmentKedua : Fragment() {
    private var _binding : FragmentKeduaBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentKeduaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnToThree.setOnClickListener {
            if (binding.etNama.text.isNotEmpty()){
                val biodata = FragmentKeduaDirections.actionFragmentKeduaToFragmentKetiga()
                biodata.nama = binding.etNama.text.toString()
                it.findNavController().navigate(biodata)
            } else {
                Toast.makeText(requireContext(), "Nama Tidak boleh Kosong!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}