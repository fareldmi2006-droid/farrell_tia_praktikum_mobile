package com.example.farrell_tia.Home.pertemuan_10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.farrell_tia.databinding.FragmentTabCBinding

class TabCFragment : Fragment() {

    private var _binding: FragmentTabCBinding? = null
    private val binding get() = _binding!!

    // Data menu kopi (Latihan 5.2: minimal 10 menu)
    private val productList = listOf(
        ProductModel("Espresso", "Rp 18.000", "https://picsum.photos/seed/espresso/400/300"),
        ProductModel("Americano", "Rp 20.000", "https://picsum.photos/seed/americano/400/300"),
        ProductModel("Cappuccino", "Rp 25.000", "https://picsum.photos/seed/cappuccino/400/300"),
        ProductModel("Caffe Latte", "Rp 25.000", "https://picsum.photos/seed/latte/400/300"),
        ProductModel("Mocha", "Rp 28.000", "https://picsum.photos/seed/mocha/400/300"),
        ProductModel("Kopi Susu Gula Aren", "Rp 22.000", "https://picsum.photos/seed/aren/400/300"),
        ProductModel("Caramel Macchiato", "Rp 30.000", "https://picsum.photos/seed/caramel/400/300"),
        ProductModel("Vanilla Latte", "Rp 28.000", "https://picsum.photos/seed/vanilla/400/300"),
        ProductModel("Cold Brew", "Rp 27.000", "https://picsum.photos/seed/coldbrew/400/300"),
        ProductModel("Affogato", "Rp 32.000", "https://picsum.photos/seed/affogato/400/300"),
        ProductModel("Kopi Tubruk", "Rp 15.000", "https://picsum.photos/seed/tubruk/400/300"),
        ProductModel("Matcha Latte", "Rp 27.000", "https://picsum.photos/seed/matcha/400/300")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Adapter + aksi klik (Toast nama kopi)
        val productAdapter = ProductAdapter(productList) { selectedItem ->
            Toast.makeText(
                requireContext(),
                "Anda memilih ${selectedItem.name}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.rvProducts.apply {
            // Grid 2 kolom
            layoutManager = GridLayoutManager(requireContext(), 2)
            // Kalau mau daftar biasa (1 kolom):
            // layoutManager = LinearLayoutManager(requireContext())
            adapter = productAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}