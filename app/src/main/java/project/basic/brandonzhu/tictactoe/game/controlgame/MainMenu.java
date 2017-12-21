package project.basic.brandonzhu.tictactoe.game.controlgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import project.basic.brandonzhu.tictactoe.R;


/**
 * Created by ezzhubr on 12/19/2017.
 */

public class MainMenu extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);


        Button playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameIntent = new Intent(MainMenu.this, GameActivity.class);
                startActivity(gameIntent);
            }
        });
    }



}
