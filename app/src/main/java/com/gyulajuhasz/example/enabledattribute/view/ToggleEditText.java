package com.gyulajuhasz.example.enabledattribute.view;

import com.gyulajuhasz.example.enabledattribute.R;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * EditText with a toggle on its left that enables and disables it.
 */
public class ToggleEditText extends LinearLayout {

    private final CheckBox checkBox;
    private final EditText editText;

    private final CompoundButton.OnCheckedChangeListener onCheckedChangeListener =
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    setEnabled(isChecked);
                }
            };

    public ToggleEditText(Context context) {
        this(context, null);
    }

    public ToggleEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ToggleEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(LinearLayout.HORIZONTAL);
        LayoutInflater.from(context).inflate(R.layout.toggle_edit_text, this);
        checkBox = (CheckBox) findViewById(R.id.toggle_edit_text_check_box);
        editText = (EditText) findViewById(R.id.toggle_edit_text_edit_text);
        checkBox.setOnCheckedChangeListener(onCheckedChangeListener);
        Log.v("ToggleEditText", "Enabled: " + isEnabled());
    }

    @Override
    public void setEnabled(boolean enabled) {
        if (enabled == isEnabled()) {
            return;
        }
        super.setEnabled(enabled);
        editText.setEnabled(enabled);
        checkBox.setOnCheckedChangeListener(null);
        checkBox.setChecked(enabled);
        checkBox.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    /**
     * Toggles the widget.
     */
    public void toggle() {
        setEnabled(!isEnabled());
    }

}
