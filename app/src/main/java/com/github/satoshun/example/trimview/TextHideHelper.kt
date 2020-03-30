package com.github.satoshun.example.trimview

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintHelper
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isGone
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.updateLayoutParams

class TextHideHelper @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : ConstraintHelper(context, attrs, defStyleAttr) {
  override fun updatePostMeasure(container: ConstraintLayout) {
    super.updatePostMeasure(container)
    val views = getViews(container)
    if (container.measuredWidth == 0) return
    if (views.size <= 1) return

    val target = views.first()
    if (target.isGone) return
    if (target !is TextView) return
    if (target.text.isNullOrEmpty()) return

    val totalWidth = views.map { it.marginLeft + it.measuredWidth + it.marginRight }.sum()
    val containerWidth = container.measuredWidth - container.paddingLeft - container.paddingRight

    if (containerWidth < totalWidth) {
      target.text = null
      target.updateLayoutParams { width = 50 }
    }
  }
}