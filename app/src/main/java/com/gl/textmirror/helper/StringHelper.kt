package com.gl.textmirror.helper

import javax.inject.Inject

/**
 * String Helper class, provides common helper functions.
 */
class StringHelper @Inject constructor() : IStringHelper {

    override fun reverseText(textInput: String): String {
        return textInput.reversed()
    }
}