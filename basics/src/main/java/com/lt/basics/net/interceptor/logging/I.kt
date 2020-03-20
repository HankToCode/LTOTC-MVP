package com.lt.basics.net.interceptor.logging

import okhttp3.internal.platform.Platform
import java.util.logging.Level
import java.util.logging.Logger

/**
 * @author ihsan on 10/02/2017.
 */
internal open class I protected constructor() {
    companion object {
        @JvmStatic
        fun log(type: Int, tag: String?, msg: String?) {
            val logger = Logger.getLogger(tag)
            when (type) {
                Platform.INFO -> logger.log(Level.INFO, msg)
                else -> logger.log(Level.WARNING, msg)
            }
        }
    }

    init {
        throw UnsupportedOperationException()
    }
}