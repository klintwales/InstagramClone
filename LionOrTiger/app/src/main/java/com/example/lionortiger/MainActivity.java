package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    enum Player{

        ONE, TWO, No

    }

    Player currentPlayer = Player.ONE;

    Player[] playerChoices = new Player[9];

    int [][] winnerRowsColumns = {{0,1,2}, {3,4,5}, {6,7,8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    private boolean gameOver = false;

    private Button btnReset;

    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int index = 0; index < playerChoices.length; index ++){
            playerChoices[index] = Player.No;
        }

        btnReset = findViewById(R.id.btnReset);

        gridLayout = findViewById(R.id.gridLayout);

        btnReset.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick (View v){

                    resetTheGame();
                }

            });



    }

    public void imageViewIsTapped (View imageView) {
        ImageView tappedImageView = (ImageView) imageView;
        int tiTag = Integer.parseInt(tappedImageView.getTag().toString());


        if (playerChoices[tiTag] == Player.No && gameOver == false) {
            tappedImageView.setTranslationX(-2000);

            playerChoices[tiTag] = currentPlayer;
            if (currentPlayer == Player.ONE) {
                tappedImageView.setImageResource(R.drawable.lion);
                currentPlayer = Player.TWO;

            } else if (currentPlayer == Player.TWO) {
                tappedImageView.setImageResource(R.drawable.tiger);
                currentPlayer = Player.ONE;
            }


            tappedImageView.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);
            /*Toast.makeText(this, tappedImageView.getTag().toString(), Toast.LENGTH_SHORT).show();*/

            for (int[] winnerColumns : winnerRowsColumns) {
                if (playerChoices[winnerColumns[0]]
                        == playerChoices[winnerColumns[1]]
                        && playerChoices[winnerColumns[1]]
                        == playerChoices[winnerColumns[2]] && playerChoices[winnerColumns[0]] != Player.No) {

                    btnReset.setVisibility(View.VISIBLE);

                    String winnerOfGame = "";

                    if (currentPlayer == Player.ONE) {

                        winnerOfGame = "two";
                    }

                    if (currentPlayer == Player.TWO) {

                        winnerOfGame = "one";
                    }

                    Toast.makeText(this, "Player " + winnerOfGame + " wins!", Toast.LENGTH_LONG).show();
                    gameOver = true;
                }
            }

        }
    }

        //reset game function
    private void resetTheGame() {

        for (int index = 0; index < gridLayout.getChildCount(); index++){

            ImageView imageView = (ImageView) gridLayout.getChildAt(index);
            imageView.setImageDrawable(null);
            imageView.setAlpha(0.2f);
            btnReset.setVisibility(View.GONE);
        }
        
        currentPlayer = Player.ONE;

       for (int index = 0; index < playerChoices.length; index ++){
           playerChoices[index] = Player.No;
       }
        gameOver = false;

    }
}
