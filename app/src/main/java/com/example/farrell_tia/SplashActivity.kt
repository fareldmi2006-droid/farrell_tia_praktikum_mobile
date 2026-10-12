
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
            val sharedPreferences = getSharedPreferences(
                "UserSession",
                MODE_PRIVATE
            )

            val isLogin = sharedPreferences.getBoolean(
                "isLogin",
                false
            )

            if (isLogin) {
                startActivity(
                    Intent(this, MainActivity::class.java)
                )
            } else {
                startActivity(
                    Intent(this, LoginActivity::class.java)
                )
            }

            finish()
        }, 2000)
    }
}
