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



public class MainActivity extends AppCompatActivity {

    String addr_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button numb1 = ((Button)this.findViewById(R.id.b));
        //numb1.setOnClickListener(this);

       // String buttonText = b.getText().toString();
        Button buttons[][] = new Button[3][3];

        for(int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "t" + i  + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = ((Button) findViewById(resID));
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = getApplicationContext();
                        //getResources().getResourceEntryName(v.getId())
                        addr_button = getResources().getResourceEntryName(v.getId());
                        //Log.i("hi",getResources().getResourceEntryName(v.getId()));
                        //Toast.makeText(context,v.getId(),1).show();

                    }
                });
            }
        }
    }







}
