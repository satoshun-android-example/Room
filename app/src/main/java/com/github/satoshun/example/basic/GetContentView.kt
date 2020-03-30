package com.github.satoshun.example.basic

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get

fun Activity.getContentView(): View =
  findViewById<ViewGroup>(android.R.id.content)[0]