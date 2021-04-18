package com.example.stickoworld

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.appindexing.FirebaseAppIndex
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException
import com.google.firebase.appindexing.Indexable
import java.io.IOException
import java.util.*

object AppIndexingUtil {
    private const val STICKER_URL_PATTERN = "mystickers://sticker/%s"
    private const val STICKER_PACK_URL_PATTERN = "mystickers://sticker/pack/%s"
    private const val CONTENT_PROVIDER_STICKER_PACK_NAME = "Firebase Storage Content Pack"
    private const val TAG = "AppIndexingUtil"
    private const val FAILED_TO_INSTALL_STICKERS = "Failed to install stickers"
    fun setStickers(context: Context?, firebaseAppIndex: FirebaseAppIndex) {
        try {
            val stickers = getIndexableStickers()
            val stickerPack = getIndexableStickerPack(stickers)
            val indexables: MutableList<Indexable> = ArrayList(stickers)
            indexables.add(stickerPack)
            val task = firebaseAppIndex.update(
                *indexables.toTypedArray())
            task.addOnSuccessListener {
                Toast.makeText(context, "Successfully added stickers", Toast.LENGTH_SHORT)
                    .show()
            }
            task.addOnFailureListener { e ->
                Log.d(TAG, FAILED_TO_INSTALL_STICKERS, e)
                Toast.makeText(context, FAILED_TO_INSTALL_STICKERS, Toast.LENGTH_SHORT)
                    .show()
            }
        } catch (e: IOException) {
            Log.e(TAG, "Unable to set stickers", e)
        } catch (e: FirebaseAppIndexingInvalidArgumentException) {
            Log.e(TAG, "Unable to set stickers", e)
        }
    }

    @Throws(IOException::class, FirebaseAppIndexingInvalidArgumentException::class)
    private fun getIndexableStickerPack(stickers: List<Indexable>): Indexable {
        val indexableBuilder =
            getIndexableBuilder(StickersDataFactory.getAllStickerReference().get(0).getURL(),
                STICKER_PACK_URL_PATTERN,
                stickers.size)
        indexableBuilder.put("hasSticker", *stickers.toTypedArray())
        return indexableBuilder.build()
    }

    @Throws(IOException::class, FirebaseAppIndexingInvalidArgumentException::class)
    private fun getIndexableStickers(): List<Indexable> {
        val indexableStickers: MutableList<Indexable> = ArrayList()
        for (i in 1 until StickersDataFactory.getAllStickerReference().size()) {
            val indexableStickerBuilder =
                getIndexableBuilder(StickersDataFactory.getAllStickerReference().get(i).getURL(),
                    STICKER_URL_PATTERN,
                    i)
            indexableStickerBuilder.put("keywords",
                "tag1_$i",
                "tag2_$i") // StickerPack object that the sticker is part of.
                .put("partOf", Indexable.Builder("StickerPack")
                    .setName(CONTENT_PROVIDER_STICKER_PACK_NAME)
                    .build())
            indexableStickers.add(indexableStickerBuilder.build())
        }
        return indexableStickers
    }

    @Throws(IOException::class)
    private fun getIndexableBuilder(
        stickerURL: String,
        urlPattern: String,
        index: Int,
    ): Indexable.Builder {
        val url = String.format(urlPattern, index)
        return Indexable.Builder("StickerPack") // name of the sticker pack
            .setName(CONTENT_PROVIDER_STICKER_PACK_NAME) // Firebase App Indexing unique key that must match an intent-filter
            // (e.g. mystickers://stickers/pack/0)
            .setUrl(url) // (Optional) - Defaults to the first sticker in "hasSticker"
            // displayed as a category image to select between sticker packs that should
            // be representative of the sticker pack
            //.setImage(contentUri.toString())
            .setImage(stickerURL) // (Optional) - Defaults to a generic phrase
            // content description of the image that is used for accessibility
            // (e.g. TalkBack)
            .setDescription("Indexable description")
    }
}