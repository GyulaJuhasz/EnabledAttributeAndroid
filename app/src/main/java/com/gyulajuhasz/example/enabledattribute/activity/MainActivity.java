package com.gyulajuhasz.example.enabledattribute.activity;

import com.gyulajuhasz.example.enabledattribute.R;
import com.gyulajuhasz.example.enabledattribute.view.ToggleEditText;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ToggleEditText toggleEditText;
    private Button toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        toggleEditText = (ToggleEditText) findViewById(R.id.main_activity_toggle_edit_text);
        toggleButton = (Button) findViewById(R.id.main_activity_toggle_button);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleEditText.toggle();
            }
        });
    }
}
