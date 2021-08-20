package com.gl.textmirror.di

import android.content.Context
import com.gl.textmirror.view.HomeActivity
import dagger.BindsInstance
import dagger.Component

/**
 * The component interface for dagger injection.
 */
@Component(modules = [AppModule::class])
public interface IComponentInterface {

    // Factory to create instances of the IComponentInterface
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): IComponentInterface
    }
    fun inject(Activity: HomeActivity)
}