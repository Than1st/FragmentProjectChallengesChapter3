package com.than.challengeschapter3

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.than.challengeschapter3.databinding.FragmentKeempatBinding

class FragmentKeempat : Fragment() {
    private var _binding : FragmentKeempatBinding? = null
    private val binding get() = _binding!!
    private val args: FragmentKeempatArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentKeempatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnToThree.setOnClickListener {
            when {
                binding.etUsia.text.isEmpty() -> {
                    Toast.makeText(requireContext(), "Umur tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                }
                binding.etUsia.text.toString().toInt() <= 0 -> {
                    Toast.makeText(requireContext(), "Umur harus lebih dari nol!", Toast.LENGTH_SHORT).show()
                }
                binding.etAlamat.text.isEmpty() -> {
                    Toast.makeText(requireContext(), "Alamat tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                }
                binding.etPekerjaan.text.isEmpty() -> {
                    Toast.makeText(requireContext(), "Pekerjaan tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    var usia = binding.etUsia.text.toString().toInt()
                    var alamat = binding.etAlamat.text.toString()
                    var pekerjaan = binding.etPekerjaan.text.toString()
                    val biodata = Biodata(args.nama, usia, alamat, pekerjaan)
                    val kirim = FragmentKeempatDirections.actionFragmentKeempatToFragmentKetiga(biodata, args.nama)
                    it.findNavController().navigate(kirim)

                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}