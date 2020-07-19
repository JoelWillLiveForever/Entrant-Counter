package com.jdev.entrantcounter;

import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EntrantCounterActivity extends AppCompatActivity {

    private Button mAddButton;
    private Button mDeleteButton;
    private TextView mProcessedTextView;

    private Counter mEntrantCounter = new Counter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrant_counter);

        mAddButton = findViewById(R.id.button_add);
        mDeleteButton = findViewById(R.id.button_delete);

        mProcessedTextView = findViewById(R.id.textView_processed);
        updateTextView();

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDeleteButton.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                mEntrantCounter.setCount((short)(mEntrantCounter.getCount() + 1));
                updateTextView();
            }
        });

        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDeleteButton.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                if (mEntrantCounter.getCount() > 0)
                    mEntrantCounter.setCount((short)(mEntrantCounter.getCount() - 1));
                updateTextView();
            }
        });
    }

    private void updateTextView() {
        mProcessedTextView.setText(String.valueOf(mEntrantCounter.getCount()));
    }
}