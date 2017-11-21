package project.basic.brandonzhu.tictactoe;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button numb1 = ((Button)this.findViewById(R.id.b));
        //numb1.setOnClickListener(this);

        Button b = (Button)findViewById(R.id.b);
        String buttonText = b.getText().toString();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // button 1 was clicked!
            }
        });
    }



       // new AlertDialog().Builder(this).setTitle("Info").setMessage(pressed).setNeutralButton("Okey", null).show();

    public String getId(View view) {
        if (view.getId() == 0xffffffff)
            return "no-id";
        else
            return view.getResources().getResourceName(view.getId());
    }





}
