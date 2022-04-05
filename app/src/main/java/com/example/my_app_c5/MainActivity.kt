package com.example.my_app_c5

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.my_app_c5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LoginContract.View{
    private lateinit var binding: ActivityMainBinding
    private var presenter:LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = LoginPresenter()
        presenter?.onAttach(this)

        binding.buttonLogin.setOnClickListener{
            presenter?.onLogin(binding.editTextLogin.text.toString(), binding.editTextPassword.text.toString())
        }
    }

    override fun setSuccess() {
        runOnUiThread{
            binding.editTextLogin.isVisible = false
            binding.editTextPassword.isVisible = false
            binding.buttonLogin.isVisible = false
            binding.root.setBackgroundColor(Color.GREEN)
        }
    }

    override fun setError(error: String) {
        runOnUiThread{
            Toast.makeText(this, "Ошибка: $error", Toast.LENGTH_SHORT).show()
        }
    }

    override fun showProgress() {
        binding.buttonLogin.isEnabled = true
        val textView = TextView(this)
        textView.apply {
            text = "Выполняется авторизация..."
            textSize = 20F
            gravity = Gravity.CENTER
        }
        binding.root.addView(textView,3)
    }

    override fun hideProgress() {
        runOnUiThread {
            binding.root.getChildAt(3).isVisible = false }
    }
}