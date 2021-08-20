package com.gl.textmirror

import com.gl.textmirror.helper.IStringHelper
import com.gl.textmirror.helper.StringHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Test for StringHelper.
 */
@RunWith(MockitoJUnitRunner::class)
class StringHelperTest {

    @Test
    fun testReverseText(){
        val inputString = "String to reverse"
        var expectedOutput = inputString.reversed()
        var stringHelper: IStringHelper = StringHelper()
        var actualOutput = stringHelper.reverseText(inputString)
        Assert.assertEquals("Failed to get reversed string", actualOutput,expectedOutput)
    }
}