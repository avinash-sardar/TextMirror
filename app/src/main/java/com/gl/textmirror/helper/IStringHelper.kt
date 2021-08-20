package com.gl.textmirror.helper

/**
 * String Helper interface, provides common helper functions.
 */
open interface IStringHelper {
    /**
     * Reverse the string provided.
     * @param textInput String
     *
     * @return processed String
     */
    fun reverseText(textInput: String): String
}