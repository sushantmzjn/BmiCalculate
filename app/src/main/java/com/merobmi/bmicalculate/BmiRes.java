package com.merobmi.bmicalculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class BmiRes extends AppCompatActivity {

    private TextView Fres, feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_res);

        Fres = findViewById(R.id.Bmiresult);
        feedback = findViewById(R.id.feedback);


        Intent intent = new Intent();
        String res = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        Fres.setText("Your BMI is "+res);

        String feed = getIntent().getStringExtra(Intent.EXTRA_SPLIT_NAME);
        feedback.setText(feed);


    }

}
