package project.basic.brandonzhu.tictactoe.game.controlgame;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import project.basic.brandonzhu.tictactoe.game.modelgamelogic.TicTacToe;

import project.basic.brandonzhu.tictactoe.R;


public class GameActivity extends AppCompatActivity {

    private String addr_button;
    public int count;
    private TicTacToe tictactoe;
    private Button[][] buttons = new Button[3][3];

    public void viewBoard(TicTacToe gameModel) {
        tictactoe = gameModel;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "t" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = ((Button) findViewById(resID));
                buttons[i][j].setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Context context = getApplicationContext();

                        addr_button = getResources().getResourceEntryName(v.getId());


                    }
                });
            }
        }

    }

    public void setButton(){

    }



/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);


    }
*/



/*


    private void reset (ArrayList<Integer> array_buttons) {
        for (int j = 0; j < array_buttons.size(); j++) {
            Button reset = (Button) findViewById(array_buttons.get(j));
            reset.setBackgroundResource(R.drawable.molang_neutral);
            reset.setClickable(true);
        }
    }
*/

/*
    private void change_button(int idval, int oddeven, String location){


        Button changePic = (Button)findViewById(idval);

        if (oddeven%2== 0){
            changePic.setBackgroundResource(R.drawable.molang_o);
            changePic.setClickable(false);
            save_o.add(Integer.valueOf(location.substring(1)));
        }
        else{
            changePic.setBackgroundResource(R.drawable.molang_x);
            changePic.setClickable(false);
            save_x.add(Integer.valueOf(location.substring(1)));
        }

    }

*/




}
