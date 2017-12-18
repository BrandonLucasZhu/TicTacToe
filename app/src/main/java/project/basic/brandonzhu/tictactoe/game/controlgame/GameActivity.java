package project.basic.brandonzhu.tictactoe.game.controlgame;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import project.basic.brandonzhu.tictactoe.game.modelgamelogic.TicTacToe;
import java.util.ArrayList;

import project.basic.brandonzhu.tictactoe.R;


public class GameActivity extends AppCompatActivity {

    private String addr_button;
    public int count;
    private TicTacToe tictactoe;

    public void viewBoard(TicTacToe gameModel){
        tictactoe = gameModel;

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button numb1 = ((Button)this.findViewById(R.id.b));
        //numb1.setOnClickListener(this);

       // String buttonText = b.getText().toString();
        Button buttons[] = new Button[9];

        for(int i = 0; i < 9; i++) { //Implement magic square
           // for (int j = 0; j < 3; j++) {
                String buttonID = "t" + i;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i] = ((Button) findViewById(resID));
                buttons[i].setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Context context = getApplicationContext();
                        //getResources().getResourceEntryName(v.getId())
                        addr_button = getResources().getResourceEntryName(v.getId());
                       // change_button(v.getId(),count,addr_button);

                        //Log.i("hi",getResources().getResourceEntryName(v.getId()));
                        //Toast.makeText(context,v.getId(),1).show();
                    }
                });
            }

    }




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
