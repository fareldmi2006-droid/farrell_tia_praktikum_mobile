package com.example.farrell_tia.More

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.farrell_tia.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {

    // View Binding di Fragment
    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    // Data untuk ListView: setiap item punya judul dan deskripsi
    private val dataListWithDesc = listOf(
        mapOf("title" to "Kotlin", "desc" to "Bahasa utama untuk Android"),
        mapOf("title" to "Java", "desc" to "Bahasa klasik untuk Android"),
        mapOf("title" to "Python", "desc" to "Populer untuk data dan AI"),
        mapOf("title" to "JavaScript", "desc" to "Bahasa untuk website"),
        mapOf("title" to "Dart", "desc" to "Bahasa untuk Flutter"),
        mapOf("title" to "Swift", "desc" to "Bahasa untuk iOS"),
        mapOf("title" to "PHP", "desc" to "Bahasa untuk backend web"),
        mapOf("title" to "SQL", "desc" to "Bahasa untuk database")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Toolbar
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "More"

        // SimpleAdapter: "title" masuk ke text1, "desc" masuk ke text2
        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        binding.listViewItems.adapter = adapter

        // Aksi saat item diklik
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val title = dataListWithDesc[position]["title"]
            val desc = dataListWithDesc[position]["desc"]
            Toast.makeText(requireContext(), "Kamu memilih: $title ($desc)", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
