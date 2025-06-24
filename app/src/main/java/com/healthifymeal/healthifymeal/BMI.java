package com.healthifymeal.healthifymeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputLayout;

public class BMI extends AppCompatActivity {

    TextView txtShowBMI;
    Button calculateBMI;
    TextInputLayout inpWeight, inpFeet, inpInches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_bmi);

        txtShowBMI = findViewById(R.id.show_bmi);
        inpWeight = findViewById(R.id.weight_input);
        inpFeet = findViewById(R.id.feet_input);
        inpInches = findViewById(R.id.inches_input);
        calculateBMI = findViewById(R.id.calculate_bmi_now);
    }

    public void callDashboard(View view) {

        Intent intent = new Intent(BMI.this, Dashboard.class);
        startActivity(intent);
    }

    public void callGenerateMealPlan(View view) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(BMI.this, generateMealPlan1.class);
                startActivity(intent);
            }
        }, 2500);
    }


    public void calculateBMI(View view) {

        String weight = inpWeight.getEditText().getText().toString().trim();
        String feet = inpFeet.getEditText().getText().toString().trim();
        String inches = inpInches.getEditText().getText().toString().trim();

        double weight_new = Double.parseDouble(weight);
        double feet_new = Double.parseDouble(feet);
        double inches_new = Double.parseDouble(inches);

        double feeToMeters = feet_new/3.281;
        double inchesToMeters = inches_new/39.37;
        double totalHeight = feeToMeters + inchesToMeters;

        double bmi = weight_new/Math.pow(totalHeight, 2);
        String verdict="";
        if (bmi < 18.5)
            verdict="You are in the underweight range.";
        else if(bmi >= 18.5 && bmi <= 24.9)
            verdict="You are in the underweight range.";
        else if (bmi >= 25.0 && bmi <= 29.9)
            verdict="You are in the overweight range.";
        else if (bmi >= 30.0 && bmi <= 34.9)
            verdict="You are in the obese range.";
        else
            verdict="You are in the extremely obese range";

        txtShowBMI.setText(verdict+"\nYour BMI is: "+bmi);

        callGenerateMealPlan(view);

    }


}