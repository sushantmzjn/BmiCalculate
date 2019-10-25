package com.merobmi.bmicalculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtweight, txtheight;
    private Button Calculate;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtweight=findViewById(R.id.weight);
        txtheight=findViewById(R.id.height);
        Calculate=findViewById(R.id.btncal);
        res=findViewById(R.id.result);

        Calculate.setOnClickListener(this);

    }

    @Override
    public void onClick(final View v) {
    int x;
        if(TextUtils.isEmpty(txtweight.getText().toString())){ txtweight.setError("Enter your weight");  return;}
        else if (TextUtils.isEmpty(txtheight.getText().toString())){ txtheight.setError("Enter your height");  return;}

        double Weight = Double.parseDouble(txtweight.getText().toString());
        double Height = Double.parseDouble(txtheight.getText().toString());

        final double C = Weight/(Height*Height);

        res.setText(String.valueOf(C));

        String result = null;

        if (C<16){ result = "Serve Thinness"; }
        if (C>=16 && C<=17 ){ result = "Moderate Thinness";}
        if (C>17 && C<=18.5){ result = "Mild Thinness";}
        if (C>18.5 && C<=25){result = "Normal";}
        if (C>25 && C<=30){result = "Overweight";}
        if (C>30){result = "Obese Class";}



        int delay = 1000;

        Timer timer = new Timer();

        final String finalResult = result;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                Intent intent = new Intent();
               // switch  (v.getId()){

                    //case R.id.btncal:

                        intent = new Intent(MainActivity.this, BmiRes.class);
                        intent.putExtra(Intent.EXTRA_TEXT, String.valueOf(C));
                        intent.putExtra(Intent.EXTRA_SPLIT_NAME, String.valueOf(finalResult));
                        startActivity(intent);


                }
        }, delay);
    }

}
