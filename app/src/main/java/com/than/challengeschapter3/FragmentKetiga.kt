package com.than.challengeschapter3

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.than.challengeschapter3.databinding.FragmentKetigaBinding

class FragmentKetiga : Fragment() {
    private var _binding : FragmentKetigaBinding? = null
    private val binding get() = _binding!!
    private val args: FragmentKetigaArgs by navArgs()
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
        var nama = args.nama
        val parcelBiodata = args.currentBiodata
        var biodata = nama
        if (parcelBiodata.usia > 0){
            var oddOrEven = if(parcelBiodata.usia%2==0) "Genap" else "Ganjil"
            biodata += "\n${parcelBiodata.usia}, $oddOrEven\n${parcelBiodata.alamat}\n${parcelBiodata.pekerjaan}"
        }
        binding.tvBiodata.text = biodata
        binding.btnToFour.setOnClickListener {
            val kirimNama = FragmentKetigaDirections.actionFragmentKetigaToFragmentKeempat()
            kirimNama.nama = nama
            it.findNavController().navigate(kirimNama)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}