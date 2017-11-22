package project.basic.brandonzhu.tictactoe;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



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
                        // button 1 was clicked!
                        Context context = getApplicationContext();
                        Toast.makeText(context,"Hello",1).show();
                        // b.setVisibility(View.VISIBLE);
                    }
                });
            }
        }
    }



       // new AlertDialog().Builder(this).setTitle("Info").setMessage(pressed).setNeutralButton("Okey", null).show();

    public String getId(View view) {
        if (view.getId() == 0xffffffff)
            return "no-id";
        else
            return view.getResources().getResourceName(view.getId());
    }





}
