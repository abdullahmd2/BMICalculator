package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText heightv;
    EditText weightv;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightv = (EditText) findViewById(R.id.height);
        weightv = (EditText) findViewById(R.id.weight);
        calculate = (Button) findViewById(R.id.button);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String inputs
                String height = heightv.getText().toString();
                String weight = weightv.getText().toString();

                if (height != null && weight != null && !weight.equals("") && !height.equals("")) {

                    //Typecasting string to float
                    Float ht = Float.parseFloat(height);
                    Float wt = Float.parseFloat(weight);

                    //Formula for calculating BMI
                    Float bmi = wt / (ht * ht);

                    String category = "";

                    if (bmi < 18.5)
                        category = "Under Weight";
                    else if (bmi >= 18.5 && bmi <= 24.9)
                        category = "Normal";
                    else if (bmi >= 25 && bmi <= 29.9)
                        category = "Over Weight";
                    else {
                        category = "Obese";
                    }
                    Intent i = new Intent(MainActivity.this,BMI.class);
                    i.putExtra("result","Your BMI is:\n"+bmi+"\n"+category);
                    startActivity(i);

                } else {
                    Toast.makeText(MainActivity.this, "Please enter valid values", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}