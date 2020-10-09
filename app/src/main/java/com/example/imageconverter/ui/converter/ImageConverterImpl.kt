package com.example.imageconverter.ui.converter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import com.example.imageconverter.mvp.model.Conversion
import com.example.imageconverter.mvp.model.ImageConverter
import io.reactivex.rxjava3.core.Completable
import timber.log.Timber

class ImageConverterImpl(private val context: Context) : ImageConverter {
    override var imageBitmap: Bitmap? = null

    override fun convertJpgToPng(conversion: Conversion): Completable {
        return Completable.fromAction {

            try {
                Thread.sleep(5000)
            } catch (e: InterruptedException) {
                Timber.e(e)
            }

            val src = Uri.parse(conversion.getSrc())
            val dst = Uri.parse(conversion.getDst())

            val source = ImageDecoder.createSource(context.contentResolver, src)
            imageBitmap = ImageDecoder.decodeBitmap(source)

            imageBitmap!!.compress(
                Bitmap.CompressFormat.PNG,
                100,
                context.contentResolver.openOutputStream(dst)
            )

            Timber.d("Converted")
        }
    }
}