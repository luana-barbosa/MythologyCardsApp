package com.luanabarbosa.toolkit.extensions

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

fun TextView.setValueOrDefault(value: String?, defaultText: String): TextView {
    text = value ?: defaultText
    return this
}

fun ImageView.load(url: String?) {
    Picasso.get()
        .load(url)
        .into(this)
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}
