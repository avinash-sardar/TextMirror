package com.gl.textmirror.view

/**
 * Holds the contract methods for View
 */
open interface IHomeView {
    /**
     * Clear the input edit text.
     */
    fun clearFields()

    /**
     * Used by presenter to get input string.
     * @return string provided by user.
     */
    fun provideInputString(): String

    /**
     * Show the output text on the screen.
     * @param outputText text to display.
     */
    fun renderOutputString(outputText : String)
}