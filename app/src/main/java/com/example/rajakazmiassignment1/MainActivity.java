package com.example.rajakazmiassignment1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // To get current time
        TextView currentTime =findViewById(R.id.time);
        currentTime.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));

        // Variable assign
        EditText inputTemperature =findViewById(R.id.input_Temprature);
        Button celsiusButton =findViewById(R.id.celsius);
        Button fahrenheitButton =findViewById(R.id.fahrenheit);
        TextView resultTextView = findViewById(R.id.result);

        // OnClickListener for Celsius

        celsiusButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                String input = inputTemperature.getText().toString();
                if (input.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter a value", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    double temperature =Double.parseDouble(input);
                    double celsius = (temperature -32)* 5/9;  //logic to calculate celsius
                    resultTextView.setText(String.format("%.2f°C",celsius));
                }
                catch ( NumberFormatException error)
                {
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();

                }
            }
        });

        // OnClickListener for Fahrenheit
        fahrenheitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputTemperature.getText().toString();
                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a temperature value", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double temperature = Double.parseDouble(input);
                    double fahrenheit = temperature * 9 / 5 + 32;
                    resultTextView.setText(String.format("%.2f°F", fahrenheit)); //logic to calculate Fahrenheit
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        }


        );



    }
}