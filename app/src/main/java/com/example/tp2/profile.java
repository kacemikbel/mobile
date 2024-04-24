package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        // Referencing the UI elements from the layout
        Button calculateButton = findViewById(R.id.buttonCalculate);
        final EditText editTextValue1 = findViewById(R.id.editTextValue1);
        final EditText editTextValue2 = findViewById(R.id.editTextValue2);
        final RadioGroup radioGroupOptions = findViewById(R.id.radioGroupOptions);
        final TextView textViewResult = findViewById(R.id.textViewResult);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double weight = Double.parseDouble(editTextValue1.getText().toString());
                    double height = Double.parseDouble(editTextValue2.getText().toString());
                    int checkedRadioButtonId = radioGroupOptions.getCheckedRadioButtonId();

                    if (checkedRadioButtonId == -1) {
                        Toast.makeText(getApplicationContext(), "Please select gender", Toast.LENGTH_LONG).show();
                        return;
                    }

                    boolean isMale = checkedRadioButtonId == R.id.radioButtonOption1;
                    double bmr = calculateBMR(isMale, weight, height);
                    textViewResult.setText("Calories needed (BMR): " + bmr);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Please enter valid numbers", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private double calculateBMR(boolean isMale, double weight, double height) {
        if (isMale) {
            // Harris-Benedict Equation for men
            return 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * 25); // Assuming age 25
        } else {
            // Harris-Benedict Equation for women
            return 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * 25); // Assuming age 25
        }
    }
}
