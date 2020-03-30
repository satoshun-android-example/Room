package com.github.satoshun.example.basic

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.NestedNestScrollViewActBinding

class BasicActivity : AppCompatActivity() {

  private lateinit var binding: NestedNestScrollViewActBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.nested_nest_scroll_view_act)

    binding.hoge.setOnClickListener {
      binding.top.scrollTo(0, 0)
    }
    binding.hoge2.setOnClickListener {
      binding.top.scrollTo(0, 10000)
    }

    binding.hoge3.setOnClickListener {
      scrollToTargetView(binding.hoge2)
    }
  }

  private fun scrollToTargetView(targetView: View) {
    binding.top.scrollTo(0, targetView.top - binding.top.height + targetView.height)
  }
}