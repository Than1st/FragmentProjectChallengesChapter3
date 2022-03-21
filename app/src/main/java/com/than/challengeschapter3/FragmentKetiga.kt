package com.than.challengeschapter3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.than.challengeschapter3.databinding.FragmentKetigaBinding

class FragmentKetiga : Fragment() {
    private var _binding : FragmentKetigaBinding? = null
    private val binding get() = _binding!!
    private val args:FragmentKetigaArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentKetigaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var biodata = args.nama
        if (args.usia > 0){
            val bernilai = if (args.usia%2==0) "Genap" else "Ganjil"
            val usia = "\nUsia ${args.usia}, $bernilai"
            val alamat = "\n${args.alamat}"
            val pekerjaan = "\n${args.pekerjaan}"
            biodata += usia + alamat + pekerjaan
        }
        binding.tvBiodata.text = biodata
        binding.btnToFour.setOnClickListener {
            val kirimNama = FragmentKetigaDirections.actionFragmentKetigaToFragmentKeempat()
            kirimNama.nama = args.nama.toString()
            it.findNavController().navigate(kirimNama)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}