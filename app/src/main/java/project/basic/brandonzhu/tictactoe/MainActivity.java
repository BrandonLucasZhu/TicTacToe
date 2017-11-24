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


public class MainActivity extends AppCompatActivity {

    private String addr_button;
    public int count;
    private ArrayList<Integer> save_id = new ArrayList<Integer>();
    private int[] save_O = new int [9];
    private int[] save_X = new int [9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button numb1 = ((Button)this.findViewById(R.id.b));
        //numb1.setOnClickListener(this);

       // String buttonText = b.getText().toString();
        Button buttons[] = new Button[9];

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
                        }

                        if (find3numbers(save_O)){
                            Toast.makeText(context,"Winner",1).show();
                        }
                        else if (find3numbers(save_X)){
                            Toast.makeText(context,"Winner",1).show();
                        }

                        //Log.i("hi",getResources().getResourceEntryName(v.getId()));
                        //Toast.makeText(context,v.getId(),1).show();
                    }
                });
            }

    }

    private void reset (ArrayList<Integer> array_buttons) {
        for (int j = 0; j < array_buttons.size(); j++) {
            Button reset = (Button) findViewById(array_buttons.get(j));
            reset.setBackgroundResource(R.drawable.molang_neutral);
            reset.setClickable(true);
        }
    }


    private boolean find3numbers(int [] array_search ){
        Arrays.sort(array_search);
        int k = 15;
        for(int first = 0; first < array_search.length()-2; first++) {
            int second = first+1;
            int third = array_search.size()-1;
            int sum = k - array_search.get(first);
            while(second < third) {
                int currentSum = array_search.get(second) + array_search.get(third);

                if(currentSum == sum) {
                    return true;
                } else if(currentSum < sum) {
                    second++;
                } else {
                    third--;
                }
            }
        }

    return false;

    }

    private void change_button(int idval, int oddeven, String addr_button){

        int coord = Integer.valueOf(addr_button.substring(1)); //Only have the coordinate value of the Tic Tac Toe
        Button changePic = (Button)findViewById(idval);

        if (oddeven%2== 0){
            changePic.setBackgroundResource(R.drawable.molang_o);
            changePic.setClickable(false);
            save_O.add(coord);
        }
        else{
            changePic.setBackgroundResource(R.drawable.molang_x);
            changePic.setClickable(false);
            save_X.add(coord);
        }

    }






}
