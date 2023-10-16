package com.example.flooringcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    private EditText widthEditText;
    private EditText lengthEditText;
    private Button showResultButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        widthEditText = findViewById(R.id.widthEditText);
        lengthEditText = findViewById(R.id.lengthEditText);
        showResultButton = findViewById(R.id.showResultButton);
        resultTextView = findViewById(R.id.mainResultTextView); // Add this TextView to activity_main.xml to display the result

        showResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double width = Double.parseDouble(widthEditText.getText().toString());
                double length = Double.parseDouble(lengthEditText.getText().toString());
                Room room = new Room(width, length);

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("room", room);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            double result = data.getDoubleExtra("result", 0.0);
            resultTextView.setText("Flooring needed: " + result + " sq units");
        }
    }
}