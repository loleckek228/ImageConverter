package com.example.imageconverter.ui.converter

import android.net.Uri
import com.example.imageconverter.mvp.model.Conversion

class ConversionImpl(private val src: Uri?, private val dst: Uri) : Conversion {
    override fun getSrc() = src.toString()

    override fun getDst() = dst.toString()
}