package com.example.interfaceinjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Ui Components
    private Button btnThrowJab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThrowJab = findViewById(R.id.btnThrowJab);

       final Boxer boxerA = new Boxer();


        boxerA.throwJab();


        btnThrowJab.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, boxerA.throwJab(),
                        Toast.LENGTH_SHORT).show();


            }
        });


    }
}
