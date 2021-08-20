package com.gl.textmirror

import android.app.Application
import com.gl.textmirror.di.DaggerIComponentInterface
import com.gl.textmirror.di.IComponentInterface

/**
 * THe application class.
 */
open class TextMirrorApplication : Application() {
    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: IComponentInterface by lazy {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        DaggerIComponentInterface.factory().create(applicationContext)
    }
}
