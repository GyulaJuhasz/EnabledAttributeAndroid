package com.gyulajuhasz.example.enabledattribute.view;

import com.gyulajuhasz.example.enabledattribute.R;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Custom edit text.
 */
public class CustomEditText extends AppCompatEditText {

    public CustomEditText(Context context) {
        this(context, null);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.editTextStyle);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.v("CustomEditText", "Enabled: " + isEnabled());
    }
}
