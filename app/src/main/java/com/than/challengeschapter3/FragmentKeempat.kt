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
                binding.etHargaPerDus.text.isEmpty() -> {
                    Toast.makeText(requireContext(), "Harga Per Dus Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show()
                }
                binding.etHargaPerDus.text.toString().toInt() <= 0 -> {
                    Toast.makeText(requireContext(), "harga Per Dus harus lebih dari nol!", Toast.LENGTH_SHORT).show()
                }
                binding.etPiecePerDus.text.toString().toInt() <= 0 -> {
                    Toast.makeText(requireContext(), "Jumlah Piece harus lebih dari nol!", Toast.LENGTH_SHORT).show()
                }
                binding.etHargaJualPerPiece.text.toString().toInt() <= 0 -> {
                    Toast.makeText(requireContext(), "Harga Jual harus lebih dari nol!", Toast.LENGTH_SHORT).show()
                }
                binding.etPiecePerDus.text.isEmpty() -> {
                    Toast.makeText(requireContext(), "Jumlah Piece tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                }
                binding.etHargaJualPerPiece.text.isEmpty() -> {
                    Toast.makeText(requireContext(), "Harga Jual tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    var hargaPerDus = binding.etHargaPerDus.text.toString().toInt()
                    var piecePerDus = binding.etPiecePerDus.text.toString().toInt()
                    var hargaJualPerPiece = binding.etHargaJualPerPiece.text.toString().toInt()
                    val keuntungan = Keuntungan(hargaPerDus, piecePerDus, hargaJualPerPiece)
                    val kirim = FragmentKeempatDirections.actionFragmentKeempatToFragmentKetiga(keuntungan, args.nama)
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