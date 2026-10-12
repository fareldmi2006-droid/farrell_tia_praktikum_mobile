
package com.example.farrell_tia.pertemuan6

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.farrell_tia.R
import com.example.farrell_tia.databinding.ActivityAnamBinding

class AnamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAnamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Konfigurasi Toolbar
        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            title = "Pertemuan 6"
            subtitle = "Penerapan Fragment"
            setDisplayHomeAsUpEnabled(true)
        }

        // Tampilkan Fragment pertama saat Activity dibuka
        if (savedInstanceState == null) {
            replaceFragment(SatuFragment(), addToBackStack = false)
        }

        // Tombol untuk berpindah Fragment
        binding.btnFragment1.setOnClickListener {
            replaceFragment(SatuFragment())
        }

        binding.btnFragment2.setOnClickListener {
            replaceFragment(DuaFragment())
        }

        binding.btnFragment3.setOnClickListener {
            replaceFragment(TigaFragment())
        }
    }

    private fun replaceFragment(
        fragment: Fragment,
        addToBackStack: Boolean = true
    ) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
