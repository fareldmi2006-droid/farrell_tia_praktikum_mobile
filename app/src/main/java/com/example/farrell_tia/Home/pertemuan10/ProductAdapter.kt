package com.example.farrell_tia.Home.pertemuan_10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.farrell_tia.databinding.ItemProductBinding

class ProductAdapter(
    private val productList: List<ProductModel>,
    private val onItemClick: (ProductModel) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    // ViewHolder: menyimpan komponen 1 baris (lewat binding)
    inner class ProductViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    // Membuat tampilan baris (hanya sebanyak yang muat di layar)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ProductViewHolder(binding)
    }

    // Mengisi baris dengan data pada posisi tertentu
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = productList[position]
        with(holder.binding) {
            tvProductName.text = item.name
            tvProductPrice.text = item.price
            Glide.with(holder.itemView.context)
                .load(item.imageUrl)
                .into(imgProduct)
            root.setOnClickListener { onItemClick(item) }
        }
    }

    // Jumlah data
    override fun getItemCount(): Int = productList.size
}