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
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

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
            binding.holder.visibility = View.VISIBLE
            binding.tvTutorial.visibility = View.GONE
            binding.btnToFour.visibility = View.GONE
            binding.tvWelcome.visibility = View.GONE
            binding.detil.tvHargaPerDus.text = currency(parcelKeuntungan.hargaPerDus)
            binding.detil.tvJumlahPiece.text = parcelKeuntungan.piecePerDus.toString()
            binding.detil.tvJumlahPiece2.text = parcelKeuntungan.piecePerDus.toString()
            binding.detil.tvHargaPerPiece.text = currency(hargaPerPiece)
            binding.detil.tvHargaJualPerPiece.text = currency(parcelKeuntungan.hargaJualPerPiece)
            binding.detil.tvHasilPenjualan.text = currency(totalHabisTerjual)
            binding.detil.tvKeuntunganAnda.text = currency(keuntungan)
            binding.detil.tvHasilAnda.text = "Hasil Perhitungan $nama"

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

    private fun currency(angka: Int): String {
        val kursIndonesia = DecimalFormat.getCurrencyInstance() as DecimalFormat
        val formatRp = DecimalFormatSymbols()

        formatRp.currencySymbol = "Rp "
        formatRp.monetaryDecimalSeparator = ','
        formatRp.groupingSeparator = '.'

        kursIndonesia.decimalFormatSymbols = formatRp
        return kursIndonesia.format(angka).dropLast(3)
    }
}