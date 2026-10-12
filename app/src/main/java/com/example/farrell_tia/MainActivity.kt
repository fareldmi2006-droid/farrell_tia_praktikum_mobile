
package com.example.farrell_tia

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.farrell_tia.databinding.ActivityMainBinding
import com.example.farrell_tia.pertemuan5.LimaActivity
import com.example.farrell_tia.pertemuan6.AnamActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur padding agar konten tidak tertutup system bar
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )

            view.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        // Menampilkan data dari Intent
        val user = intent.getStringExtra("Username")
        val pass = intent.getStringExtra("Password")

        binding.txtUsername.text = user ?: "Username"
        binding.txtPassword.text = pass ?: "Password"

        // Tombol Snackbar
        binding.btnSnackBar.setOnClickListener {
            Snackbar.make(
                binding.root,
                "Halo iki snackbar lurr",
                Snackbar.LENGTH_LONG
            )
                .setAction("Info") {
                    // Aksi ketika Info ditekan
                }
                .show()
        }

        // Tombol Alert Dialog
        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Hapus data")
                .setMessage(
                    "Data yang dihapus tidak bisa dikembalikan."
                )
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->
                    // Proses hapus data dapat ditambahkan di sini
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }

        // Navigasi ke Pertemuan 5
        binding.btnToLima.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                LimaActivity::class.java
            )
            startActivity(intent)
        }

        // Navigasi ke Pertemuan 6
        binding.btnToEnam.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                AnamActivity::class.java
            )
            startActivity(intent)
        }
    }
}
