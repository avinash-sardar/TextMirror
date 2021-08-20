package com.gl.textmirror.presenter

import com.gl.textmirror.view.IHomeView

/**
 * Holds the contract methods for presenter.
 */
open interface IHomePresenter {
    /**
     * Notify the presenter when UI is visible to user.
     * @param homeView reference to View
     */
    fun notifyUIReady(homeView: IHomeView)

    /**
     * Notify the presenter when submit action is performed.
     */
    fun notifySubmit()

}