package com.gl.textmirror.di

import com.gl.textmirror.helper.IStringHelper
import com.gl.textmirror.helper.StringHelper
import com.gl.textmirror.presenter.HomePresenter
import com.gl.textmirror.presenter.IHomePresenter
import dagger.Module
import dagger.Provides

/**
 * Specifies the dependency creation for Dagger.
 */
@Module
class AppModule {

    /**
     * Provide instance of StringHelper.
     *
     * @return instance of type IStringHelper
     */
    @Provides
    fun provideStingHelper(): IStringHelper {
        return StringHelper()
    }

    /**
     * Provides instance for HomePresenter.
     *
     * @return instance of type IHomePresenter
     */
    @Provides
    fun provideHomePresenter(): IHomePresenter {
        return HomePresenter(provideStingHelper() as StringHelper)
    }
}