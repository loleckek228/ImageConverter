package com.example.imageconverter.mvp.model

import android.graphics.Bitmap
import io.reactivex.rxjava3.core.Completable

interface ImageConverter {
    val imageBitmap: Bitmap?
    fun convertJpgToPng(conversion: Conversion): Completable
}