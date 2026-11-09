package com.example.farrell_tia.Home.pertemuan_10

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.farrell_tia.R
import com.example.farrell_tia.databinding.ActivityTenthBinding
import com.google.android.material.tabs.TabLayoutMediator
import androidx.core.content.ContextCompat
class TenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Toolbar + tombol back
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Pertemuan 10"
        binding.toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        binding.toolbar.setNavigationOnClickListener { finish() }
        // 1. Buat adapter
        val tabsAdapter = TenthTabsAdapter(this)

        // 2. Pasang adapter ke ViewPager2
        binding.viewPager.adapter = tabsAdapter

        // 3. Hubungkan TabLayout dan ViewPager2
        // 3. Hubungkan TabLayout dan ViewPager2 + ikon & badge
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Promo"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_promo)
                    // Badge angka = jumlah promo yang aktif
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                    badge.number = 3
                }
                1 -> {
                    tab.text = "Tentang"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_info)
                }
            }
        }.attach()
    }
}