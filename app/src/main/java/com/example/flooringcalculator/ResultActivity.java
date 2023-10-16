package com.example.flooringcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView resultTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = findViewById(R.id.resultTextView);
        backButton = findViewById(R.id.backButton);  // You'll add this button in the XML layout

        Room room = (Room) getIntent().getSerializableExtra("room");
        double result = room.getFlooringNeeded();

        resultTextView.setText("Width: " + room.getWidth() + ", Length: " + room.getLength() + "\nTotal Flooring Needed: " + result + " sq units");

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", result);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}