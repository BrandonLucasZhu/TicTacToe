package project.basic.brandonzhu.tictactoe.game.controlgame;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Timer;
import java.util.TimerTask;

import project.basic.brandonzhu.tictactoe.game.modelgamelogic.TicTacToe;

import project.basic.brandonzhu.tictactoe.R;


public class GameActivity extends AppCompatActivity {

    private TicTacToeView visualBoard;
    public TicTacToe gameModel = new TicTacToe();
    private PopupWindow winnerWindow;
    private Toast popUpMess;

    private class TicTacToeView {
        private String addrButton;
        private TicTacToe tictactoeBoard;
        private Button[][] buttons = new Button[3][3];


        public void viewBoard(TicTacToe gameModel) {
            tictactoeBoard = gameModel;


            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    String buttonID = "t" + i + j;
                    int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    buttons[i][j] = ((Button) findViewById(resID));
                    buttons[i][j].setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {

                            Context context = getApplicationContext();
                            addrButton = getResources().getResourceEntryName(v.getId());

                            Log.d("hi", "hi");

                            setButton(tictactoeBoard,addrButton,v);
                            if (tictactoeBoard.check_winner() != "tie"){ //Display winner if no tie
                                popUpMess = Toast.makeText(getApplicationContext(), "We have a winner!", 50000);
                                popUpMess.show();
                                showWinnerPopUp(tictactoeBoard);
                                tictactoeBoard.reset();
                                resetGraphics();

                            }
                            else if (tictactoeBoard.tie()){
                                popUpMess = Toast.makeText(getApplicationContext(), "We have a tie!", 5000);
                                popUpMess.show();
                                showWinnerPopUp(tictactoeBoard);
                                resetGraphics();
                            }

                        }
                    });
                }
            }
        }
    }

    public void setButton(TicTacToe board, String location, View button){
        String coord = location.substring(1);
        int firstIndex = Character.getNumericValue(coord.charAt(0)); //Get the id of the button and split the id into two coordinates i and j
        int secondIndex = Character.getNumericValue(coord.charAt(1));
        board.setMove(firstIndex,secondIndex);
        changeButton(board,button);


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

    }


    @Override
    public void onStart() {
        super.onStart();
        setUp();
    }


    @Override
    public void onPause() {
        super.onPause();



    }


    public void setUp(){
        visualBoard = new TicTacToeView();
        visualBoard.viewBoard(gameModel);
    }







    private void resetGraphics () {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "t" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                Button reset = (Button) findViewById(resID);
                reset.setBackgroundResource(R.drawable.molang_neutral);
                reset.setClickable(true);
            }
        }
    }


    private void changeButton(TicTacToe board,View idval){


        Button changePic = (Button)findViewById(idval.getId());

        if (board.getPlayerTurn()== "O"){
            changePic.setBackgroundResource(R.drawable.molang_o); //Change button texture and set button unclickable
            changePic.setClickable(false);

        }
        else{
            changePic.setBackgroundResource(R.drawable.molang_x);
            changePic.setClickable(false);

        }

    }

    private void showWinnerPopUp(TicTacToe checkBoard){
        if (winnerWindow == null) {
            View winnerPopup = getLayoutInflater().inflate(R.layout.winner, null);
            winnerWindow = new PopupWindow(this);
            winnerWindow.setContentView(winnerPopup);
        }

        winnerWindow.showAtLocation(findViewById(R.id.activity_main), Gravity.CENTER, 0, 0); //Get id of room xml game_activity show popup in the center

        //Get display metrics of the screen
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int imageSize = (int) (metrics.widthPixels * 0.6);
        int textSize = (int) (metrics.widthPixels * 0.1);

        //resize the pop up window
        winnerWindow.update(0, 0, imageSize, imageSize + textSize);

        ImageView animView = (ImageView) winnerWindow.getContentView().findViewById(R.id.winner_image);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(imageSize, imageSize);
        animView.setLayoutParams(lp);

        TextView animText = (TextView) winnerWindow.getContentView().findViewById(R.id.winner_text);





        int spritesId;
        if (checkBoard.check_winner() == "X_WIN") {
            spritesId = R.layout.winner_molangs;

        } else if (checkBoard.check_winner() == "O_WIN") {
            spritesId = R.layout.winner_bolangs;

        } else {
            spritesId = R.layout.winner_tie;

        }

        animView.setBackgroundResource(spritesId);
        AnimationDrawable winnerAnimation = (AnimationDrawable) animView.getBackground();
        winnerAnimation.start();


        final Handler handler  = new Handler();
        handler.postDelayed(new Runnable() { //display popup for only a couple of seconds

            @Override
            public void run() {
                winnerWindow.dismiss();
            }

        }, 5000);
    }








}
