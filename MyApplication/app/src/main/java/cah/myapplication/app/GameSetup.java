package cah.myapplication.app;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;


public class GameSetup extends ActionBarActivity {

    NumberPicker np, np2;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_setup);
        np = (NumberPicker) findViewById(R.id.numberPicker1);

        np.setMinValue(3);
        np.setMaxValue(8);
        np.setWrapSelectorWheel(false);

        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                Game.numPlayers = i2;
            }
        });


        np2 = (NumberPicker) findViewById(R.id.numberPicker2);

        np2.setMinValue(1);
        np2.setMaxValue(6);
        np2.setWrapSelectorWheel(false);

        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                Game.maxAwesomePoints = i2;
            }
        });






        gamePlayGame();
        backToMenuButton();
    }


    private void gamePlayGame(){
        Button btnPlayGame= (Button) findViewById(R.id.btnPlayGame);

        btnPlayGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PlayGameActivity.class));
            }
        });
    }

    private void backToMenuButton(){

        Button btnToMenu = (Button) findViewById(R.id.btnToMenu);

        btnToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game_setup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
