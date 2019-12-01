package com.example.oopjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnThrowJab;
    Boxer myBoxer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThrowJab = findViewById(R.id.btnThrowJab);

         myBoxer = new Boxer(0, 400, 900);

       // Log.i("MyTag", myBoxer.toString());

        KickBoxer myKickBoxer = new KickBoxer(2, 700, 20, 30, 500);

       // Log.i("MyTag", myKickBoxer.toString());

      //  myBoxer.punchSpeed = 900;

     //   Log.i("MyTag", "Punch Speed: " + myBoxer.punchSpeed +
       //         " Punch Power: " + myBoxer.punchPower);

      //  myKickBoxer.kickPower = 500;
     //   myKickBoxer.punchPower = 700;

     //   Log.i("MyTag", "kick Speed: " + myKickBoxer.kickSpeed +
            //    " kick Power: " + myKickBoxer.kickPower);


     //   Log.i("MyTag",  (new Boxer()) + "");
     //   Log.i("MyTag",  (new Boxer()) + "");



        myBoxer.setNumberOfGloves(10);


        Log.i("MyTag", myBoxer.getNumberOfGloves() + "");

        myBoxer.setStamina(40);

        Boxer newBoxer = new Boxer(4, 50, 80);
      //  Log.i("MyTag", "New Boxer Stamina" + newBoxer.stamina);

       // newBoxer.stamina = 70;

      //  Log.i("MyTag", "My Boxer Stamina" + myBoxer.stamina);

       Boxer.setStamina(20);

        Log.i("MyTag", "All Boxers Stamina " +  Boxer.getStamina());


        myBoxer.throwJab();



    }

    public void throwJabIsClicked(View buttonView) {

        Toast.makeText(MainActivity.this, myBoxer.throwJab(),
                Toast.LENGTH_LONG).show();

    }
}
