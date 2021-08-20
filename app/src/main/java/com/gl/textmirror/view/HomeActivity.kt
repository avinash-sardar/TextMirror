package com.gl.textmirror.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gl.textmirror.TextMirrorApplication
import com.gl.textmirror.R
import com.gl.textmirror.presenter.HomePresenter
import javax.inject.Inject


/**
 * Launcher Activity class.
 */
class HomeActivity: IHomeView, View.OnClickListener, AppCompatActivity() {

    /**
     * Inject presenter dependency.
     */
    @Inject
    lateinit var mHomePresenter: HomePresenter

    /**
     * Instance of user input edit text.
     */
    lateinit var mEdtUserInput : EditText

    /**
     * Instance of TextView to display output.
     */
    lateinit var mOutputText : TextView

    /**
     * Instance of submit Button.
     */
    lateinit var mSubmitButton : Button

     /**
     * Initialize UI components for activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // Ask Dagger to inject our dependencies
        (application as TextMirrorApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
         mEdtUserInput  = findViewById<EditText>(R.id.edit_user_input_text)
         mOutputText  = findViewById<TextView>(R.id.output_text)
         mSubmitButton = findViewById<Button>(R.id.button_submit)
         mSubmitButton.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        // Notify the presenter when UI is ready.
        mHomePresenter.notifyUIReady(this)
    }

    override fun clearFields() {
        mOutputText.setText("")
        mEdtUserInput.setText("")
    }

    override fun provideInputString(): String {
        return mEdtUserInput.text.toString()
    }

    override fun renderOutputString(outputText: String) {
        mOutputText.setText(outputText)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            // Notify presenter when submit button is clicked.
            R.id.button_submit -> mHomePresenter.notifySubmit()
        }
    }
}