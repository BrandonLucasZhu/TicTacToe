package project.basic.brandonzhu.tictactoe;

import android.content.Context;
import android.content.DialogInterface;
import android.nfc.Tag;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private String addr_button;
    public int count;
    private ArrayList<Integer> save_id = new ArrayList<Integer>();
    private ArrayList<Integer> save_o = new ArrayList<Integer>();
    private ArrayList<Integer> save_x = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button numb1 = ((Button)this.findViewById(R.id.b));
        //numb1.setOnClickListener(this);

       // String buttonText = b.getText().toString();
        Button buttons[] = new Button[10];

        for(int i=1; i<10; i++) { //Implement magic square
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
                        change_button(v.getId(),count,addr_button);
                        save_id.add(v.getId());
                        count++;
                        if (count>8){
                            count=0;
                            reset(save_id);
                            save_o.clear();
                            save_x.clear();
                        }
                        else if (checkWinner(save_o)) {
                            Toast.makeText(context,"Winner",1).show();
                            reset(save_id);
                            save_o.clear();
                            count = 0;
                        }
                        else if (checkWinner(save_x)) {
                            Toast.makeText(context,"Winner",1).show();
                            reset(save_id);
                            save_x.clear();
                            count = 0;
                        }
                        //Log.i("hi",getResources().getResourceEntryName(v.getId()));
                        //Toast.makeText(context,v.getId(),1).show();
                    }
                });
            }

    }


    private Boolean checkWinner(ArrayList<Integer> x_or_o){
        int[][] win_condi = {{8,1,6},{3,5,7},{4,9,2},{8,3,4},{1,5,9},{6,7,2},{8,5,2},{4,5,6}};
        int count_xo= 0;


        for (int set = 0; set < win_condi.length; set++) {

            for (int pos = 0; pos < 3; pos++) {
                int current = win_condi[set][pos];
                for (int i = 0; i < x_or_o.size(); i++) {
                    if (current == x_or_o.get(i)) {

                        Log.i("hi", String.valueOf(current));
                        count_xo++;
                    }
                }
            }
            if (count_xo == 3) {
                return true;
            }
            count = 0;
        }

        return false;
    }




    private void reset (ArrayList<Integer> array_buttons) {
        for (int j = 0; j < array_buttons.size(); j++) {
            Button reset = (Button) findViewById(array_buttons.get(j));
            reset.setBackgroundResource(R.drawable.molang_neutral);
            reset.setClickable(true);
        }
    }



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






}
