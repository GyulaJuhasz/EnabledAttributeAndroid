package com.gyulajuhasz.example.enabledattribute.view;

import com.gyulajuhasz.example.enabledattribute.R;

import android.content.Context;
import android.util.AttributeSet;
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
                    updateState();
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
        updateState();
    }

    private void updateState() {
        setEnabled(checkBox.isChecked());
    }

    @Override
    public void setEnabled(boolean enabled) {
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
