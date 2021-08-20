package com.gl.textmirror.presenter

import com.gl.textmirror.helper.IStringHelper
import com.gl.textmirror.view.IHomeView
import javax.inject.Inject

/**
 * Presenter implementation view.
 */
class HomePresenter @Inject constructor(var stringHelper: IStringHelper) : IHomePresenter {

    /**
     * Holds the view reference.
     */
    lateinit var mHomeView: IHomeView

    override fun notifyUIReady(homeView: IHomeView) {
        mHomeView = homeView
        mHomeView.clearFields()
    }

    override fun notifySubmit() {
        var outputString = stringHelper.reverseText(mHomeView.provideInputString())
        mHomeView.renderOutputString(outputString)
    }
}