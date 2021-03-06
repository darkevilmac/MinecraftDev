/*
 * Minecraft Dev for IntelliJ
 *
 * https://minecraftdev.org
 *
 * Copyright (c) 2017 minecraft-dev
 *
 * MIT License
 */

package com.demonwav.mcdev.platform.liteloader.version

import com.demonwav.mcdev.util.sortVersions
import com.google.gson.Gson
import java.io.IOException
import java.net.URL

class LiteLoaderVersion private constructor(private var map: Map<*, *>) {

    val sortedMcVersions: List<String> by lazy {
        val mcVersion = map["versions"] as Map<*, *>
        sortVersions(mcVersion.keys)
    }

    companion object {
        fun downloadData(): LiteLoaderVersion? {
            try {
                val text = URL("http://dl.liteloader.com/versions/versions.json").readText()

                val map = Gson().fromJson(text, Map::class.java)
                val liteLoaderVersion = LiteLoaderVersion(map)
                liteLoaderVersion.sortedMcVersions
                return liteLoaderVersion
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return null
        }
    }
}
