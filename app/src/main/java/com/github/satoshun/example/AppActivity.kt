package com.github.satoshun.example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.satoshun.example.basic.BasicActivity
import com.github.satoshun.example.basic.getContentView
import com.github.satoshun.example.databinding.AppActBinding

class AppActivity : AppCompatActivity() {
  private lateinit var binding: AppActBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.app_act)
    binding = AppActBinding.bind(getContentView())

    binding.basic.setOnClickListener {
      startActivity(
        Intent(this@AppActivity, BasicActivity::class.java)
      )
    }
  }
}
