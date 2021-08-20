package com.gl.textmirror

import com.gl.textmirror.helper.IStringHelper
import com.gl.textmirror.presenter.HomePresenter
import com.gl.textmirror.view.IHomeView
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

/**
 * Test class for HomePresenter.
 */
@RunWith(MockitoJUnitRunner::class)
open class HomePresenterTest {
    /**
     * Mock instance of IStringHelper.
     */
    @Mock
    lateinit var mStringHelper: IStringHelper

    /**
     * Mock instance of IHomeView.
     */
    @Mock
    lateinit var mHomeView: IHomeView

    /**
     * Instance of Presenter under test.
     */
    lateinit var mHomePresenter: HomePresenter

    @Before
    fun setup(){
        mHomePresenter = HomePresenter(mStringHelper)
        mHomePresenter.notifyUIReady(mHomeView)
    }

    /**
     * Test for notifyUiReady.
     */
    @Test
    fun testNotifyUiReady(){
        verify(mHomeView, times(1)).clearFields()
    }

    /**
     * Test for notifySubmit.
     */
    @Test
    fun testNotifySubmit(){
        val inputString = "String to reverse"
        var expectedOutput = inputString.reversed()
        Mockito.`when`(mHomeView.provideInputString()).thenReturn(inputString)
        Mockito.`when`(mStringHelper.reverseText(inputString)).thenReturn(expectedOutput)
        mHomePresenter.notifySubmit()
        verify(mHomeView, times(1)).provideInputString()
        verify(mHomeView, times(1)).renderOutputString(expectedOutput)
    }
}