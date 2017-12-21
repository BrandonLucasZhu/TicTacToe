package project.basic.brandonzhu.tictactoe.game.controlgame;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import project.basic.brandonzhu.tictactoe.game.modelgamelogic.TicTacToe;

import project.basic.brandonzhu.tictactoe.R;


public class GameActivity extends AppCompatActivity {

    private TicTacToeView visualBoard;
    public TicTacToe gameModel = new TicTacToe();

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
                            if (tictactoeBoard.check_winner()){
                                tictactoeBoard.reset();
                                resetGraphics();
                                Toast.makeText(context, "We have a winner!", Toast.LENGTH_LONG).show();
                            }
                            else if (tictactoeBoard.tie()){
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
            changePic.setBackgroundResource(R.drawable.molang_o);
            changePic.setClickable(false);
          //  save_o.add(Integer.valueOf(location.substring(1)));
        }
        else{
            changePic.setBackgroundResource(R.drawable.molang_x);
            changePic.setClickable(false);
           // save_x.add(Integer.valueOf(location.substring(1)));
        }

    }

    private void checkWinner(){

    }




}
