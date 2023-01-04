package com.mindorks.example.openpdffile.utils

import android.content.Context
import android.os.Environment
import androidx.core.content.ContextCompat
import java.io.File

object FileUtils {

    fun getPdfNameFromAssets(): String {
        return "pdf.pdf"
    }

    fun getPdfUrl(): String {
        return "https://firebasestorage.googleapis.com/v0/b/social-media-7c551.appspot.com/o/Kotlin%20Android%20App%20Development%20Course%20Module.pdf?alt=media&token=87a0d67e-3bf2-436f-be04-2b95e8873531"
    }

    fun getRootDirPath(context: Context): String {
        return if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
            val file: File = ContextCompat.getExternalFilesDirs(
                context.applicationContext,
                null
            )[0]
            file.absolutePath
        } else {
            context.applicationContext.filesDir.absolutePath
        }
    }

}