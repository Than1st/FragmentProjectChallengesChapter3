package com.than.challengeschapter3

import android.os.Bundle
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
        val nama = args.nama
        val parcelKeuntungan = args.currentKeuntungan
        var keterangan = nama
        if (parcelKeuntungan.hargaPerDus > 0){
            binding.btnToFour.visibility = View.GONE
            val hasilJual = parcelKeuntungan.hargaJualPerPiece * parcelKeuntungan.piecePerDus
            val keuntungan = hasilJual - parcelKeuntungan.hargaPerDus
            val hargaPerPiece = parcelKeuntungan.hargaPerDus / parcelKeuntungan.piecePerDus
            val untungAtauTidak = if (keuntungan > 0) "Untung Gan!" else "Kagak Untung!"
            keterangan = """
                Harga Per Dus : ${parcelKeuntungan.hargaPerDus}
                Jumlah Piece Per Dus : ${parcelKeuntungan.piecePerDus}
                Harga Per Piece : $hargaPerPiece
                Harga Jual Per Piece : ${parcelKeuntungan.hargaJualPerPiece}
                Keuntungan Yang Di Dapat : $keuntungan
                $untungAtauTidak
            """.trimIndent()

        }
        binding.tvBiodata.text = keterangan
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