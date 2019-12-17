package com.example.animationsinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtHelloWorld;
    private TextView txtHiWorld;
    private TextView txtAndroid;
    private Button btnAnimate;

    private boolean isHelloWorldShowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtHelloWorld = findViewById(R.id.txtHelloWorld);
        txtHiWorld = findViewById(R.id.txtHiWorld);
        txtAndroid = findViewById(R.id.txtAndroid);
        btnAnimate = findViewById(R.id.btnAnimate);

        txtHelloWorld.setX(2000);
        txtAndroid.setX(-2000);

        txtHelloWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtHiWorld.getAlpha() == 0) {
                    txtHelloWorld.animate().alpha(0f).setDuration(3000);
                    txtHiWorld.animate().alpha(1f).setDuration(3000);
                }
                else{
                    txtHiWorld.animate().alpha(0f).setDuration(3000);
                    txtHelloWorld.animate().alpha(1f).setDuration(3000);
                }

            }
        });

        txtAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtAndroid.animate().translationXBy(200).setDuration(5000);
            }
        });

        btnAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHelloWorld.animate().translationXBy(-2000);
                txtAndroid.animate().translationXBy(2000);
            }
        });



    }
}
