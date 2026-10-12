package com.example.farrell_tia

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.farrell_tia.databinding.ActivityLogin2Binding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogin2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        // SharedPreferences
        val sharedPreferences = getSharedPreferences(
            "UserSession",
            MODE_PRIVATE
        )

        // Tombol Login
        binding.btnlogin.setOnClickListener {
            val user = binding.editusn.text.toString().trim()
            val pass = binding.edtpasswd.text.toString()

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(
                    this,
                    "Username dan password wajib diisi",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            // Validasi sesuai contoh praktikum:
            // username harus sama dengan password
            if (user == pass) {

                // Simpan status login dan username
                sharedPreferences.edit()
                    .putBoolean("isLogin", true)
                    .putString("Username", user)
                    .apply()

                Toast.makeText(
                    this,
                    "Login berhasil",
                    Toast.LENGTH_SHORT
                ).show()

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Username", user)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(
                    this,
                    "Username dan password tidak cocok",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
