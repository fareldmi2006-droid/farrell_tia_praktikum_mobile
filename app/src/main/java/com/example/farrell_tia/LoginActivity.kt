package com.example.farrell_tia

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.farrell_tia.databinding.ActivityLogin2Binding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogin2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        val btnlogin : Button = findViewById(R.id.btnlogin)
//        val usn : EditText = findViewById(R.id.editusn)
//        val passwd : EditText = findViewById(R.id.edtpasswd)

        binding.btnlogin.setOnClickListener {

            val user = binding.editusn.text.toString()
            val pass = binding.edtpasswd.text.toString()
            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("Username", user)
            intent.putExtra("Password", pass)
            startActivity(intent)

            Log.d("Output", "Username: $user Password : $pass")
            Toast.makeText(this, "Psername $user Password :$pass", Toast.LENGTH_SHORT).show()


        }

        }

        }

