package com.than.challengeschapter3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.than.challengeschapter3.databinding.FragmentKetigaBinding
import java.text.NumberFormat
import java.util.*

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

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nama = args.nama
        binding.tvWelcome.text = "Hai, $nama!"
        val parcelKeuntungan = args.currentKeuntungan
        if (parcelKeuntungan.hargaPerDus > 0){
            binding.btnToFour.visibility = View.GONE
            val hasilJual = parcelKeuntungan.hargaJualPerPiece * parcelKeuntungan.piecePerDus
            val hargaPerPiece = parcelKeuntungan.hargaPerDus / parcelKeuntungan.piecePerDus
            val keuntungan = hasilJual - parcelKeuntungan.hargaPerDus
            val totalHabisTerjual = parcelKeuntungan.hargaJualPerPiece * parcelKeuntungan.piecePerDus
            binding.cvDetail.visibility = View.VISIBLE
            binding.tvTutorial.visibility = View.GONE
            binding.btnToFour.visibility = View.GONE
            binding.tvHargaPerDus.text = currency(parcelKeuntungan.hargaPerDus)
            binding.tvJumlahPiecePerDus.text = parcelKeuntungan.piecePerDus.toString()
            binding.tvHargaPerPiece.text = currency(hargaPerPiece)
            binding.tvHargaJualPerPiece.text = currency(parcelKeuntungan.hargaJualPerPiece)
            binding.tvTotalHabisTerjual.text = currency(totalHabisTerjual)
            binding.tvTotalKeuntungan.text = currency(keuntungan)

        }
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

    private fun currency(angka: Int): String? {
        val localeID = Locale("in", "ID")
        val formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeID)
        return formatRupiah.format(angka)
    }
}