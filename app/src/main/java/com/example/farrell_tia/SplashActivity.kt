package com.example.farrell_tia

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            val sharedPref = getSharedPreferences("UserSession", MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin", false)

            if (isLogin) {
                // sudah pernah login → langsung ke halaman utama
                startActivity(Intent(this, BaseActivity::class.java))
            } else {
                // belum login → ke halaman Login
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()   // tutup Splash supaya tombol Back tidak kembali ke sini
        }, 2000)
    }
}