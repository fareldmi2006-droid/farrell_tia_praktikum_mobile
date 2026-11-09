package com.example.farrell_tia.Message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.farrell_tia.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar

// Custom Adapter: mengubah setiap MessageModel menjadi satu baris item_message.xml
class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Pakai ulang baris lama kalau ada, kalau belum ada buat baru
        val binding = if (convertView == null) {
            ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            ItemMessageBinding.bind(convertView)
        }

        val message = messages[position]

        // Glide: ambil foto dari internet, potong bulat, tampilkan
        Glide.with(context)
            .load(message.avatarUrl)
            .circleCrop()
            .into(binding.avatarImg)

        binding.textSender.text = message.senderName
        binding.textMessage.text = message.messageText

        // Klik baris -> Snackbar
        binding.root.setOnClickListener {
            Snackbar.make(binding.root, "Pesan dari ${message.senderName}", Snackbar.LENGTH_SHORT).show()
        }

        return binding.root
    }
}
