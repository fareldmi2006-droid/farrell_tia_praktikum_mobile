package com.example.farrell_tia.Message

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.farrell_tia.Message.tutorial.TutorialMessageActivity
import com.example.farrell_tia.R
import com.example.farrell_tia.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Toolbar (P7)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Message"

        // Ikon Info di Toolbar → buka Tutorial (P9)
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.message_toolbar_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_tutorial -> {
                        startActivity(Intent(requireContext(), TutorialMessageActivity::class.java))
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        // Daftar pesan dengan Custom Adapter (P7)
        val messages = listOf(
            MessageModel("Andi", "Halo, apa kabar?", "https://avatar.iran.liara.run/public/1"),
            MessageModel("Budi", "Jangan lupa tugas besok ya", "https://avatar.iran.liara.run/public/2"),
            MessageModel("Citra", "Sudah sampai mana praktikumnya?", "https://avatar.iran.liara.run/public/3"),
            MessageModel("Dewi", "Nanti kita kerja kelompok", "https://avatar.iran.liara.run/public/4"),
            MessageModel("Eka", "Oke, sampai jumpa di kampus!", "https://avatar.iran.liara.run/public/5")
        )
        val adapter = MessageAdapter(requireContext(), messages)
        binding.listMessageItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}